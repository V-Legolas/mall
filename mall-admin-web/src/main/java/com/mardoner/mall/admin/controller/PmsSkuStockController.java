package com.mardoner.mall.admin.controller;

import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.pms.SkuStock;
import com.mardoner.mall.admin.service.pms.SkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品库存管理
* @className: PmsSkuStockController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 20:54
* @version 1.0
*/
@RestController
@RequestMapping("/product/stock")
@Api(tags = "PmsSkuStockController", description = "商品库存管理")
public class PmsSkuStockController implements IController {
    @Resource(name = "skuStockServiceImpl")
    private SkuStockService stockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @GetMapping("/list")
    public AdminResult list(String keyword){
        List<SkuStock> stockList = stockService.list(keyword);
        return new AdminResult(CommonReturnCode.SUCCESS, keyword);
    }

    @ApiOperation("批量更新某商品库存信息")
    @PutMapping("/update/batch/{pid}")
    public AdminResult updateBatch(@PathVariable Long pid,
                                   @RequestBody List<SkuStock> stockList){
        int count = stockService.update(pid,stockList);
        return getAdminResult(count);
    }
}
