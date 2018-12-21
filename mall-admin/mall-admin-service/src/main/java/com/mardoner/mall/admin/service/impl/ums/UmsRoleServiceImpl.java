package com.mardoner.mall.admin.service.impl.ums;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRole;
import com.mardoner.mall.admin.entity.ums.UmsRolePermissionRelation;
import com.mardoner.mall.admin.mapper.ums.UmsRoleMapper;
import com.mardoner.mall.admin.mapper.ums.UmsRolePermissionRelationMapper;
import com.mardoner.mall.admin.service.ums.UmsRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @Description: 管理员角色管理 业务逻辑实现
* @ClassName: UmsRoleServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/19 14:22
* @Version 1.0
*/
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole>
    implements UmsRoleService {

    @Resource(name = "umsRoleMapper")
    private UmsRoleMapper umsRoleMapper;
    @Resource(name = "umsRolePermissionRelationMapper")
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;

    @Override
    public List<UmsPermission> getPermissionsByRoleId(Long roleId) {
        return rolePermissionRelationMapper.getPermissionsByRoleId(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        // 清空原有权限记录
        UmsRolePermissionRelation deleteRecords =
                new UmsRolePermissionRelation();
        deleteRecords.setRoleId(roleId);
        rolePermissionRelationMapper.delete(new UpdateWrapper<>(deleteRecords));

        // 添加新的权限信息
        if(!CollectionUtils.isEmpty(permissionIds)){
            List<UmsRolePermissionRelation> newRelationList = new ArrayList<>();
            permissionIds.forEach(permissionId -> {
                UmsRolePermissionRelation newRelation = new UmsRolePermissionRelation();
                newRelation.setRoleId(roleId);
                newRelation.setPermissionId(permissionId);
                newRelationList.add(newRelation);
            });
            return rolePermissionRelationMapper.insertList(newRelationList);
        }
        return 0;
    }
}
