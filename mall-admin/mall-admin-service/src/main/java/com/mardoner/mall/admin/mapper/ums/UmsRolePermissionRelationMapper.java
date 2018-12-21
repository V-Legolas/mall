package com.mardoner.mall.admin.mapper.ums;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRolePermissionRelationMapper
        extends BaseMapper<UmsRolePermissionRelation> {

    /**
     * 获取角色下，所有目录
     * @param roleId 角色id
     * @return 权限集合
     */
    List<UmsPermission> getPermissionsByRoleId(@Param("roleId")Long roleId);

    /**
     * 插入集合记录
     * @param relationList 集合
     * @return 插入记录数
     */
    int insertList(@Param("list")List<UmsRolePermissionRelation> relationList);
}
