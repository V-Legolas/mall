package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.pojo.dto.vo.UmsPermissionNode;
import com.mardoner.mall.admin.service.ums.UmsPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  后台权限管理
* @ClassName: UmsPermissionController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 20:42
* @Version 1.0
*/
@Api(tags = "UmsPermissionController", description = "后台权限管理")
@RestController
@RequestMapping("/permission")
public class UmsPermissionController implements IController {

    @Resource(name = "umsPermissionServiceImpl")
    private UmsPermissionService permissionService;

    @ApiOperation("以层级结构返回所有权限")
    @GetMapping("/treeList")
    public CommonResult treeList(){
        List<UmsPermissionNode> permissionNodes = permissionService.treeList();
        return new CommonResult(CommonReturnCode.SUCCESS,permissionNodes);
    }

    @ApiOperation("获取所有权限列表")
    @GetMapping("/list")
    public CommonResult list(){
        List<UmsPermission> list = permissionService.list(new QueryWrapper<>());
        return new CommonResult(CommonReturnCode.SUCCESS,list);
    }

    @ApiOperation("根据id批量删除权限记录")
    @DeleteMapping("/delete")
    public CommonResult deleteList(@RequestParam("permissionIds") List<Long> permissionIds){
        boolean isOk = permissionService.removeByIds(permissionIds);
        return getResult(isOk);
    }

    @ApiOperation("修改权限")
    @PutMapping("/update/{permissionId}")
    public CommonResult update(@PathVariable("permissionId") Long permissionId,
                               @RequestBody UmsPermission permission){
        permission.setId(permissionId);
        boolean isOk = permissionService.updateById(permission);
        return getResult(isOk);
    }

    @ApiOperation("添加权限")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsPermission permission){
        boolean isOk = permissionService.save(permission);
        return getResult(isOk);
    }
}
