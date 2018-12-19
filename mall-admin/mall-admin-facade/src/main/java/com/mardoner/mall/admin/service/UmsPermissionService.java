package com.mardoner.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.UmsPermission;
import com.mardoner.mall.admin.pojo.dto.UmsPermissionNode;

import java.util.List;

/**
* @Description: 后台权限管理 业务逻辑接口
* @ClassName: UmsPermissionService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 19:56
* @Version 1.0
*/
public interface UmsPermissionService extends IService<UmsPermission> {

    /**
     * 层级结构返回所有权限
     * @return
     */
    List<UmsPermissionNode> treeList();
}
