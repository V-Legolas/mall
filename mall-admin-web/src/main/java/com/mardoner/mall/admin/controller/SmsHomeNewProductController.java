package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.HomeNewProduct;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.service.sms.HomeNewProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  首页新品推荐管理
* @className: SmsHomeNewProductController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:27
* @version 1.0
*/
@RestController
@Api(tags = "SmsHomeNewProductController", description = "首页新品推荐管理")
@RequestMapping("/home/newProduct")
public class SmsHomeNewProductController implements IController {
    @Resource(name = "homeNewProductServiceImpl")
    private HomeNewProductService newProductService;

    @ApiOperation("添加首页推荐新品")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<HomeNewProduct> productList){
        int count = newProductService.create(productList);
        return getResult(count);
    }

    @ApiOperation("修改首页新品推荐排序")
    @PutMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id,
                                   Integer sort){
        int count = newProductService.updateSort(id, sort);
        return getResult(count);
    }



    @ApiOperation("修改推荐状态（是否在首页显示）")
    @PutMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                              @RequestParam("recommendStatus")Integer recommendStatus){
        int count = newProductService.updateRecommendStatus(ids, recommendStatus);
        return getResult(count);
    }

    @ApiOperation("批量删除推荐")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids")List<Long> ids){
        int count = newProductService.deleteBatch(ids);
        return getResult(count);
    }

    @ApiOperation(value = "分页查询推荐",notes = "'productName'：模糊查询产品名称,'recommendStatus'推荐状态")
    @GetMapping("/list")
    public CommonResult list(String productName,Integer recommendStatus,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<HomeNewProduct> newProductPage =
                newProductService.list(productName,recommendStatus,current,limit);
        return new CommonResult(newProductPage);
    }

}
