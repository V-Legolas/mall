package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.Brand;
import com.mardoner.mall.admin.pojo.dto.param.PmsBrandParam;
import com.mardoner.mall.admin.service.pms.BrandService;
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
* @description:  商品品牌 controller
* @className: PmsBrandController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 18:05
* @version 1.0
*/
@RestController
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RequestMapping("/product/brand")
public class PmsBrandController implements IController {
    @Resource(name = "brandServiceImpl")
    private BrandService brandService;

    @ApiOperation("获取全部品牌列表")
    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult listAll(){
        List<Brand> brandList = brandService.list();
        return new CommonResult(CommonReturnCode.SUCCESS,brandList);
    }

    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult create(@Validated @RequestBody PmsBrandParam param,
                               BindingResult result){
        if(result.hasErrors()){
            return new CommonResult(result);
        }
        int count = brandService.createBrand(param);
        return getResult(count);
    }

    @ApiOperation("更新品牌")
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult update(@PathVariable Long id, @Validated @RequestBody PmsBrandParam param,
                               BindingResult result){
        if(result.hasErrors()){
            return new CommonResult(result);
        }
        int count = brandService.updateBrand(id,param);
        return getResult(count);
    }

    @ApiOperation("删除品牌")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult delete(@PathVariable Long id){
        int count = brandService.delete(id);
        return getResult(count);
    }

    @ApiOperation("根据品牌名称分页获取品牌")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult list(@RequestParam(value = "keyword",required = false)String keyword,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<Brand> brandPage = brandService.listPage(keyword,current,limit);
        return new CommonResult(brandPage);
    }

    @ApiOperation("根据主键id获取单个品牌")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult getItem(@PathVariable Long id){
        Brand brand = brandService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS, brand);
    }

    @ApiOperation("批量删除订单")
    @DeleteMapping("/delete/batch")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBatch(@RequestParam("ids")List<Long> ids){
        int count = brandService.deleteList(ids);
        return getResult(count);
    }

    @ApiOperation("批量更新显示状态")
    @PutMapping("/update/show/status")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateShowStatus(@RequestParam("ids")List<Long> ids,
                                         @RequestParam("showStatus")Integer showStatus){
        int count = brandService.updateShowStatus(ids,showStatus);
        return getResult(count);
    }

    @ApiOperation("批量更新厂家制造商状态")
    @PutMapping("/update/factory/status")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateFactoryStatus(@RequestParam("ids")List<Long> ids,
                                            @RequestParam("showStatus") @Validated @FlagValidator({"0","1"})Integer factoryStatus){
        int count = brandService.updateFactoryStatus(ids,factoryStatus);
        return getResult(count);
    }
}
