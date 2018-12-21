package com.mardoner.mall.admin.service.ums;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description: 后台角色管理 逻辑接口
* @ClassName: UmsRoleService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 19:59
* @Version 1.0
*/
public interface UmsRoleService extends IService<UmsRole> {
    /**
     * 获取指定角色权限
     */
    List<UmsPermission> getPermissionsByRoleId(Long roleId);

    /**
     * 修改指定角色的权限
     */
    @Transactional
    int updatePermission(Long roleId, List<Long> permissionIds);
}
