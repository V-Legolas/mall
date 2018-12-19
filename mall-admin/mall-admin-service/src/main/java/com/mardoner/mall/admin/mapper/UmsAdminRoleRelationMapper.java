package com.mardoner.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.UmsAdminRoleRelation;
import com.mardoner.mall.admin.entity.UmsPermission;
import com.mardoner.mall.admin.entity.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 批量插入
     * @param adminRoleRelationList 插入的集合
     * @return 插入记录数
     */
    int insertList(@Param("list")List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     *获取角色集合
     * @param adminId 管理员id
     * @return 角色集合
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 获取所有角色权限
     * @param adminId 管理员id
     * @return 权限集合
     */
    List<UmsPermission> getRolePermissionList(Long adminId);

    /**
     * 获取所有权限,包括UmsAdminRolePermissionRelation中直接定义的有效权限
     * @param adminId 管理员id
     * @return 权限集合
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
