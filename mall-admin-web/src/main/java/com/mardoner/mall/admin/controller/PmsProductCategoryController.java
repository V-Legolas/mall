package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.ProductCategory;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductCategoryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductCategoryWithChildren;
import com.mardoner.mall.admin.service.pms.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品分类 管理
* @className: PmsProductCategoryController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 19:31
* @version 1.0
*/
@RestController
@RequestMapping("/product/category")
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
public class PmsProductCategoryController implements IController {

    @Resource(name = "productCategoryServiceImpl")
    private ProductCategoryService categoryService;

    @ApiOperation("添加产品分类")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:productCategory:create')")
    public CommonResult create(@RequestBody @Validated PmsProductCategoryParam param,
                               BindingResult result){
        if(result.hasErrors()){
            return new CommonResult(result);
        }
        int count = categoryService.create(param);
        return getResult(count);
    }

    @ApiOperation("修改商品分类")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody @Validated PmsProductCategoryParam param,
                               BindingResult result){
        if (result.hasErrors()){
            return new CommonResult(result);
        }
        int count =categoryService.update(id,param);
        return getResult(count);
    }

    @ApiOperation("删除商品分类")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:productCategory:delete')")
    public CommonResult delete(@PathVariable Long id){
        int count = categoryService.delete(id);
        return getResult(count);
    }

    @ApiOperation("根据id获取商品分类")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:productCategory:read')")
    public CommonResult getItem(@PathVariable Long id){
        ProductCategory category = categoryService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS, category);
    }

    @ApiOperation("父类id分页查询商品分类")
    @GetMapping("/list/{parentId}")
    @PreAuthorize("hasAuthority('pms:productCategory:read')")
    public CommonResult listByParentCategoryId(@PathVariable("parentId") Long parentId,
                                               @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                                               @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<ProductCategory> categoryPage = categoryService.list(parentId,current,limit);
        return new CommonResult(categoryPage);
    }

    @ApiOperation("修改导航栏显示状态")
    @PutMapping("/update/nav/status")
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult updateNavStatus(@RequestParam List<Long> ids,
                                        @RequestParam(value = "navStatus") Integer navStatus) {
        int count = categoryService.updateNavStatus(ids,navStatus);
        return getResult(count);
    }

    @ApiOperation("修改显示状态")
    @PutMapping("/update/show/status")
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult updateShowStatus(@RequestParam List<Long> ids,
                                         @RequestParam("showStatus") Integer showStatus){
        int count = categoryService.updateShowStatus(ids,showStatus);
        return getResult(count);
    }


    @ApiOperation("查询所有一级分类及其子类")
    @GetMapping("/listFirstWithChild")
    public CommonResult listFirstWithChild(){
        List<PmsProductCategoryWithChildren> categoryWithChildren =
                categoryService.listWithChildren();
        return new CommonResult(CommonReturnCode.SUCCESS, categoryWithChildren);
    }
}
