package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttributeCategoryItem;
import com.mardoner.mall.admin.service.pms.ProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品属性分类 controller
* @className: PmsProductAttributeCategoryController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 18:44
* @version 1.0
*/
@RestController
@RequestMapping("/product/attribute/category")
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
public class PmsProductAttributeCategoryController implements IController {

    @Resource(name = "productAttributeCategoryServiceImpl")
    private ProductAttributeCategoryService attrCategoryService;

    @ApiOperation("添加商品属性分类")
    @PostMapping("/create")
    public CommonResult create(@RequestParam String name, BindingResult result){
        int count = attrCategoryService.create(name);
        return getResult(count);
    }

    @ApiOperation("修改商品属性分类")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestParam String name){
        int count = attrCategoryService.update(id,name);
        return getResult(count);
    }

    @ApiOperation("删除单个商品属性分类")
    @DeleteMapping("/delete/id")
    public CommonResult delete(@PathVariable Long id){
        int count = attrCategoryService.delete(id);
        return getResult(count);
    }

    @ApiOperation("获取单个商品属性分类信息")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        ProductAttributeCategory attributeCategory = attrCategoryService.get(id);
        return new CommonResult(CommonReturnCode.SUCCESS, attributeCategory);
    }

    @ApiOperation("分页获取所有商品属性分类信息")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<ProductAttributeCategory> categoryPage =
                attrCategoryService.listPage(current,limit);
        return new CommonResult(categoryPage);
    }

    @ApiOperation("获取所有商品属性分类及其下属性信息")
    @GetMapping("/list/withAttribute")
    public CommonResult listWithAttribute(){
        List<PmsProductAttributeCategoryItem> categoryWithAttr
                = attrCategoryService.listWithAttr();
        return new CommonResult(CommonReturnCode.SUCCESS, categoryWithAttr);
    }
}
