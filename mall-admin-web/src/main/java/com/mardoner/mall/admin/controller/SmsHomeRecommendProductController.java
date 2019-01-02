package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.HomeRecommendProduct;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.service.sms.HomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  首页人气商品推荐管理
* @className: SmsHomeRecommendProductController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:34
* @version 1.0
*/
@RestController
@Api(tags = "SmsHomeRecommendProductController", description = "首页人气商品推荐")
@RequestMapping("/home/recommendProduct")
public class SmsHomeRecommendProductController implements IController {
    @Resource(name = "homeRecommendProductServiceImpl")
    private HomeRecommendProductService productService;

    @ApiOperation("批量添加首页人气推荐商品")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<HomeRecommendProduct> productList){
        int count = productService.create(productList);
        return getResult(count);
    }

    @ApiOperation("批量修改首页人气推荐商品推荐状态（是否在首页显示）")
    @PutMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                              @RequestParam("recommendStatus")Integer recommendStatus){
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        return getResult(count);
    }

    @ApiOperation("修改排序状态")
    @PutMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id, Integer sort){
        int count = productService.updateSort(id, sort);
        return getResult(count);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids")List<Long> ids){
        int count = productService.deleteBatch(ids);
        return getResult(count);
    }

    @ApiOperation(value = "分页查询", notes = "‘productName’: 模糊查询商品名称，‘recommendStatus’：推荐状态")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "productName", required = false)String productName,
                             @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<HomeRecommendProduct> productPage =
                productService.list(productName, recommendStatus, current, limit);
        return new CommonResult(productPage);
    }

}
