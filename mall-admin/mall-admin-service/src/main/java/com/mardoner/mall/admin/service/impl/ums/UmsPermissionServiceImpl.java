package com.mardoner.mall.admin.service.impl.ums;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.mapper.ums.UmsPermissionMapper;
import com.mardoner.mall.admin.pojo.dto.vo.UmsPermissionNode;
import com.mardoner.mall.admin.service.ums.UmsPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission>
    implements UmsPermissionService {

    @Resource(name = "umsPermissionMapper")
    UmsPermissionMapper permissionMapper;

    @Override
    public List<UmsPermissionNode> treeList() {
        List<UmsPermission> permissionList = permissionMapper.selectList(new QueryWrapper<>());
        List<UmsPermissionNode> roots = new ArrayList<>();
        permissionList.forEach(permission -> {
            if(permission.getPid().equals(0L)){
                // 最顶级权限
                UmsPermissionNode rootNode = new UmsPermissionNode();
                BeanUtils.copyProperties(permission,rootNode);
                roots.add(rootNode);
            }
        });
        // 递归查找根级权限下子级目录
        roots.forEach(root -> listChildrenPermissions(root,permissionList));

        return roots;
    }

    private void listChildrenPermissions(UmsPermissionNode root, List<UmsPermission> permissionList) {
        // 当前权限等级的子权限
        List<UmsPermissionNode> child = new ArrayList<>();
        permissionList.forEach(permission -> {
            if(permission.getPid().equals(root.getId())){
                UmsPermissionNode node = new UmsPermissionNode();
                BeanUtils.copyProperties(permission,node);
                // 递归查询
                listChildrenPermissions(node,permissionList);
                child.add(node);
                root.setChildren(child);
            }
        });
    }
}
