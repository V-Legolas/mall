package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.ProductAttribute;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductAttributeParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttrInfo;
import com.mardoner.mall.admin.service.pms.ProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品属性管理
* @className: PmsProductAttributeController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 19:01
* @version 1.0
*/
@RestController
@RequestMapping("/product/attribute")
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
public class PmsProductAttributeController implements IController {
    @Resource(name = "productAttributeServiceImpl")
    private ProductAttributeService attributeService;

    @ApiOperation("根据分类查询属性列表或者参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @GetMapping("/list/{cid}")
    public AdminResult listByAttributeCategory(@PathVariable Long cid,
                                             @RequestParam("type")Integer type,
                                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<ProductAttribute> attrPage = attributeService.listPage(cid,type,current,limit);
        return new AdminResult(attrPage);
    }

    @ApiOperation("添加商品属性信息")
    @PostMapping("/create")
    public AdminResult create(@RequestBody @Validated PmsProductAttributeParam param,
        BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = attributeService.create(param);
        return getAdminResult(count);
    }

    @ApiOperation("修改商品属性信息")
    @PutMapping("/update/{id}")
    public AdminResult update(@PathVariable Long id,
                              @RequestBody @Validated PmsProductAttributeParam param,
                              BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = attributeService.update(id,param);
        return getAdminResult(count);
    }

    @ApiOperation("查询单个商品属性")
    @GetMapping("/{id}")
    public AdminResult getItem(@PathVariable Long id){
        ProductAttribute attribute = attributeService.getById(id);
        return new AdminResult(CommonReturnCode.SUCCESS,attribute);
    }

    @ApiOperation("批量删除商品属性")
    @DeleteMapping("/delete/batch")
    public AdminResult deleteBatch(@RequestParam("ids") List<Long> ids){
        int count = attributeService.delete(ids);
        return getAdminResult(count);
    }

    @ApiOperation("根据商品分类id获取商品属性及其属性分类")
    @GetMapping("/list/by/productCategory/{productCategoryId}")
    public AdminResult listInfoByProductCategory(@PathVariable("productCategoryId") Long id){
        List<PmsProductAttrInfo> info = attributeService.getAttrInfo(id);
        return new AdminResult(CommonReturnCode.SUCCESS,info);
    }
}
