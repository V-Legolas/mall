package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductParam;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductResult;
import com.mardoner.mall.admin.service.pms.ProductService;
import com.mardoner.mall.admin.util.SingletonLoginUtils;
import com.mardoner.mall.admin.validator.FlagValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品管理
* @className: PmsProductController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 20:06
* @version 1.0
*/
@RestController
@RequestMapping("/product")
@Api(tags = "PmsProductController",description = "商品管理")
public class PmsProductController implements IController {
    @Resource(name = "productServiceImpl")
    private ProductService productService;

    @ApiOperation("创建商品")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:product:create')")
    public AdminResult create(@RequestBody @Validated PmsProductParam param,
                              BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.create(param);
        return getAdminResult(count);
    }

    @ApiOperation("修改商品")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('pms:product:update')")
    public AdminResult update(@PathVariable Long id,
                              @RequestBody @Validated PmsProductParam param,
                              BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.update(id,param);
        return getAdminResult(count);
    }

    @ApiOperation("根据id获取单个商品编辑信息")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:product:read')")
    public AdminResult getItem(@PathVariable Long id){
        PmsProductResult product = productService.getDetail(id);
        return new AdminResult(CommonReturnCode.SUCCESS, product);
    }

    @ApiOperation("分页条件筛选商品")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:product:read')")
    public AdminResult list(PmsProductQueryParam param,
                            @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                            @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<Product> productPage = productService.listPage(param,current,limit);
        return new AdminResult(CommonReturnCode.SUCCESS, productPage);
    }

    @ApiOperation("根据商品名称或者货号模糊查询")
    @PreAuthorize("hasAuthority('pms:product:read')")
    @GetMapping("/simpleList")
    public AdminResult list(String keyword){
        List<Product> productList = productService.list(keyword);
        return new AdminResult(CommonReturnCode.SUCCESS, productList);
    }

    @ApiOperation("批量上下架商品")
    @PreAuthorize("hasAuthority('pms:product:update')")
    @PutMapping("/update/publish")
    public AdminResult updatePublishStatus(@RequestParam("ids")List<Long> ids,
                                           @FlagValidator({"0","1"}) @RequestParam("publishStatus") Integer status,
                                           BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.updatePublishStatus(ids,status);
        return getAdminResult(count);
    }


    @ApiOperation("批量审核")
    @PreAuthorize("hasAuthority('pms:product:update')")
    @PutMapping("/update/verify")
    public AdminResult updatePublishStatus(@RequestParam("ids")List<Long> ids,
                                           @FlagValidator({"0","1"}) @RequestParam("verifyStatus") Integer status,
                                           @RequestParam("detail")String detail,
                                           BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.updateVerifyStatus(ids,status,detail,
                SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

    @ApiOperation("批量新品")
    @PreAuthorize("hasAuthority('pms:product:update')")
    @PutMapping("/update/new")
    public AdminResult updateNewStatus(@RequestParam("ids")List<Long> ids,
                                           @FlagValidator({"0","1"}) @RequestParam("newStatus") Integer status,
                                           BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.updateNewStatus(ids,status);
        return getAdminResult(count);
    }

    @ApiOperation("批量推荐")
    @PreAuthorize("hasAuthority('pms:product:update')")
    @PutMapping("/update/recommend")
    public AdminResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                             @FlagValidator({"0","1"}) @RequestParam("recommendStatus") Integer status,
                                             BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.updateNewStatus(ids,status);
        return getAdminResult(count);
    }

    @ApiOperation("批量修改删除状态（逻辑删除）")
    @PreAuthorize("hasAuthority('pms:product:delete')")
    @DeleteMapping("/delete/batch")
    public AdminResult deleteLogicBatch(@RequestParam("ids")List<Long> ids,
                                   @FlagValidator({"0","1"}) @RequestParam("recommendStatus") Integer status,
                                   BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = productService.updateNewStatus(ids,status);
        return getAdminResult(count);
    }
}
