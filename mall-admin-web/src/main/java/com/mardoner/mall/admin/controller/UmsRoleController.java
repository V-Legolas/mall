package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRole;
import com.mardoner.mall.admin.service.ums.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  后台管理员角色管理
* @ClassName: UmsRoleController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 20:47
* @Version 1.0
*/
@RestController
@Api(tags = "UmsRoleController", description = "后台角色管理")
@RequestMapping("/role")
public class UmsRoleController implements IController {
    @Resource(name = "umsRoleServiceImpl")
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsRole role){
        boolean isOk = roleService.save(role);
        return getResult(isOk);
    }

    @ApiOperation("修改角色")
    @PutMapping("/update/{roleId}")
    public CommonResult update(@PathVariable("roleId") Long roleId,
                               @RequestBody UmsRole role){
        role.setId(roleId);
        boolean isOk = roleService.updateById(role);
        return getResult(isOk);
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping("/delete")
    public CommonResult deleteList(@RequestParam("roleIds")List<Long> roleIds){
        boolean isOk = roleService.removeByIds(roleIds);
        return getResult(isOk);
    }

    @ApiOperation("获取相应角色权限")
    @GetMapping("/permission/{roleId}")
    public CommonResult getPermissionById(@PathVariable("roleId") Long roleId){
        List<UmsPermission> permissionList = roleService.getPermissionsByRoleId(roleId);
        return new CommonResult(CommonReturnCode.SUCCESS,permissionList);
    }

    @ApiOperation("修改角色权限")
    @PutMapping("/permission/update")
    public CommonResult updatePermissions(@RequestParam("roleId") Long roleId,
                                          @RequestParam("permissionIds") List<Long> permissionIds){
        int count = roleService.updatePermission(roleId,permissionIds);
        return getResult(count);
    }

    @ApiOperation("获取所有角色")
    @GetMapping("/list")
    public CommonResult list(){
        List<UmsRole> roleList = roleService.list(new QueryWrapper<>());
        return new CommonResult(CommonReturnCode.SUCCESS,roleList);
    }
}
