package com.mardoner.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.UmsAdmin;
import com.mardoner.mall.admin.entity.UmsPermission;
import com.mardoner.mall.admin.entity.UmsRole;
import com.mardoner.mall.admin.pojo.dto.UmsAdminRegisterParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description: 后台管理 业务逻辑接口
* @ClassName: UmsAdminService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 19:39
* @Version 1.0
*/
public interface UmsAdminService extends IService<UmsAdmin> {

    /**
     * 根据用户名返回后台管理员
     * @param username 用户名
     * @return 后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 用户注册
     * @param param 注册信息
     * @return 注册好的账号
     */
    UmsAdmin register(UmsAdminRegisterParam param);

    /**
     * 登录用户
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    boolean login(String username, String password);

    /**
     * 分页查询所有管理员
     * @param name 昵称
     * @param index 显示开始页数 1开始
     * @param limit  每页显示记录条数
     * @return 符合条件所有管理员
     */
    List<UmsAdmin> listByPage(String name,Integer index,Integer limit);

    /**
     * 修改用户角色关系
     * @param adminId 用户id
     * @param roleIds 修改的角色id集合
     * @return 修改成功数
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取所有角色
     * @param userId 用户id
     * @return 该用户所有角色信息
     */
    List<UmsRole> getRoleList(Long userId);

    /**
     * 更改权限信息, 相当于将原有权限信息都会清除，置与无效，添加新的权限,用户到权限直接操作
     * @param adminId 管理员id
     * @param permissionIds 权限id集合
     * @return 修改成功记录数
     */
    @Transactional
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * 获取所有权限信息
     * @param adminId 管理员id
     * @return 该管理员所有权限集合
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
