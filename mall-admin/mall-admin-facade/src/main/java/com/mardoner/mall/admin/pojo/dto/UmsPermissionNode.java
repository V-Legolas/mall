package com.mardoner.mall.admin.pojo.dto;

import com.mardoner.mall.admin.entity.UmsPermission;

import java.util.List;

/**
* @Description: 用户权限节点
* @ClassName: UmsPermissionNode
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 20:40
* @Version 1.0
*/
public class UmsPermissionNode extends UmsPermission {
    private static final long serialVersionUID = 1L;

    private List<UmsPermissionNode> children;

    public List<UmsPermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<UmsPermissionNode> children) {
        this.children = children;
    }
}
