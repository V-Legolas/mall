package com.mardoner.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.*;
import com.mardoner.mall.admin.enums.StatusEnum;
import com.mardoner.mall.admin.mapper.UmsAdminLoginLogMapper;
import com.mardoner.mall.admin.mapper.UmsAdminMapper;
import com.mardoner.mall.admin.mapper.UmsAdminPermissionRelationMapper;
import com.mardoner.mall.admin.mapper.UmsAdminRoleRelationMapper;
import com.mardoner.mall.admin.pojo.dto.UmsAdminRegisterParam;
import com.mardoner.mall.admin.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin>
    implements UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Resource(name = "umsAdminMapper")
    private UmsAdminMapper adminMapper;
    @Resource(name = "umsAdminLoginLogMapper")
    private UmsAdminLoginLogMapper adminLoginLogMapper;
    @Resource(name = "umsAdminPermissionRelationMapper")
    private UmsAdminPermissionRelationMapper adminPermissionRelationMapper;
    @Resource(name = "umsAdminRoleRelationMapper")
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private AuthenticationManager authManager;

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        QueryWrapper<UmsAdmin> queryMapper = new QueryWrapper<>();
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(username);
        queryMapper.setEntity(umsAdmin);
        return adminMapper.selectOne(queryMapper);
    }

    @Override
    public boolean login(String username, String password) {
        // 密码需要客户端加密再传递到数据库验证
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(username,passwordEncoder.encode(password));
//        try{
//            Authentication authentication = authManager.authenticate(authenticationToken);
//            // 将验证信息保存至上下文
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            // 更新登录相关信息
//            updateLoginTimeByUserName(username);
//            insertLoginLog(username);
//        }catch (AuthenticationException e){
//            LOGGER.warn("登录异常：{}",e.getMessage());
//            return false;
//        }
        return true;
    }

    /**
     * 插入新的登录日志
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin query = this.getAdminByUsername(username);
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setCreateTime(new Date());
        loginLog.setAdmin_id(query.getId());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes.getRequest() != null){
            loginLog.setIp(attributes.getRequest().getRemoteAddr());
        }
        adminLoginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改最后一次登录时间
     * @param username 用户名
     */
    private void updateLoginTimeByUserName(String username) {
        UmsAdmin admin = this.getAdminByUsername(username);
        admin.setLoginTime(new Date());
        adminMapper.updateById(admin);
    }

    @Override
    public UmsAdmin register(UmsAdminRegisterParam param) {
//        UmsAdmin umsAdmin = new UmsAdmin();
//        BeanUtils.copyProperties(param,umsAdmin);
//        umsAdmin.setCreateTime(new Date());
//        umsAdmin.setStatus(StatusEnum.NORMAL.getCode());
//
//        // 查询是否含有相同用户名
//        UmsAdmin query = this.getAdminByUsername(umsAdmin.getUsername());
//        if(query != null){
//            // 数据库已存在该用户
//            return null;
//        }
//
//        // 将密码进行加密
//        String cryptPassword = passwordEncoder.encode(umsAdmin.getPassword());
//        umsAdmin.setPassword(cryptPassword);
//        // 保存到数据库
//        adminMapper.insert(umsAdmin);
//        return umsAdmin;
        return null;
    }

    @Override
    public List<UmsAdmin> listByPage(String name, Integer index, Integer limit) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("username" , name).or().like("nickname",name);
        }
        IPage<UmsAdmin> page = new Page<>();
        page.setCurrent(index);
        page.setSize(limit);
        this.page(page,queryWrapper);
        return page.getRecords();
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        UmsAdminRoleRelation deleteRecords = new UmsAdminRoleRelation();
        deleteRecords.setAdminId(adminId);
        // 先删除原来的关系
        adminRoleRelationMapper.delete(new QueryWrapper<>(deleteRecords));

        // 建立新的关系
        List<UmsAdminRoleRelation> newAdminRoleRelationList =
                new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleIds)){
            roleIds.forEach(roleId -> {
                UmsAdminRoleRelation newAdminRole = new UmsAdminRoleRelation();
                newAdminRole.setAdminId(adminId);
                newAdminRole.setRoleId(roleId);
                newAdminRoleRelationList.add(newAdminRole);
            });
        }
        return adminRoleRelationMapper.insertList(newAdminRoleRelationList);
    }

    @Override
    public List<UmsRole> getRoleList(Long userId) {
        return adminRoleRelationMapper.getRoleList(userId);
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        // 清空原来所有权限关系
        UmsAdminPermissionRelation deleteAdminPermission = new UmsAdminPermissionRelation();
        deleteAdminPermission.setAdminId(adminId);
        adminPermissionRelationMapper.delete(new QueryWrapper<>(deleteAdminPermission));

        // 获取用户所有角色权限
        List<UmsPermission> adminPermissionList =
                adminRoleRelationMapper.getRolePermissionList(adminId);
        List<Long> rolePermissionIdList = new ArrayList<>();
        adminPermissionList.forEach(adminPermission ->
                rolePermissionIdList.add(adminPermission.getId()));
        /** + - 权限 原有权限集合 A 要插入的权限集合 B ,- 权限相当于是数据库中角色权限没有的
         * +权限 = A - A交B
         * - 权限 = B - A交B
         */
        if(!CollectionUtils.isEmpty(permissionIds)){
            /** 需要插入的记录 */
            List<UmsAdminPermissionRelation> newRelationList = new ArrayList<>();
            List<Long> addPermissionList = new ArrayList<>();
            List<Long> subPermissionList = new ArrayList<>();
            /** 筛选出 + 权限 原有角色权限中没有的权限*/
            permissionIds.forEach(permissionId -> {
                if(!rolePermissionIdList.contains(permissionId)){
                    addPermissionList.add(permissionId);
                }
            });
            /** 筛选出 - 权限 */
            rolePermissionIdList.forEach(permissionId ->{
                if(!permissionIds.contains(permissionId)){
                    subPermissionList.add(permissionId);
                }
            });
            newRelationList.addAll(convert(adminId,StatusEnum.ADD_PERMISSION.getCode(),addPermissionList));
            newRelationList.addAll(convert(adminId,StatusEnum.SUB_PERMISSION.getCode(),subPermissionList));
            // 保存到数据库
            return adminPermissionRelationMapper.insertList(newRelationList);
        }
        return 0;
    }

    /** 将 + -权限关系转化为对象 */
    private Collection<? extends UmsAdminPermissionRelation> convert(Long adminId, int type, List<Long> permissionIdList) {
        List<UmsAdminPermissionRelation> relationList = new
                ArrayList<>();
        permissionIdList.forEach(permissionId ->{
            UmsAdminPermissionRelation newRelation = new UmsAdminPermissionRelation();
            newRelation.setAdminId(adminId);
            newRelation.setType(type);
            newRelation.setPermissionId(permissionId);
            relationList.add(newRelation);
        });
        return relationList;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationMapper.getPermissionList(adminId);
    }
}
