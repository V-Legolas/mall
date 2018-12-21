package com.mardoner.mall.admin.mapper.ums;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.ums.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminPermissionRelationMapper extends
        BaseMapper<UmsAdminPermissionRelation> {

    int insertList(@Param("list") List<UmsAdminPermissionRelation> list);
}
