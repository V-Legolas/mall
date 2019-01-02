package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.CouponHistory;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.service.sms.CouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @description:  消费券 领取记录管理
* @className: SmsCouponHistoryController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 15:00
* @version 1.0
*/
@RestController
@Api(tags = "SmsCouponHistoryController", description = "消费券领取记录管理")
@RequestMapping("/coupon/history")
public class SmsCouponHistoryController implements IController {
    @Resource(name = "couponHistoryServiceImpl")
    private CouponHistoryService historyService;

    @ApiOperation("根据优惠券id、使用状态和订单编号分页查询")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "id", required = false)Long couponId,
                             @RequestParam(value = "useStatus", required = false)Integer useStatus,
                             @RequestParam(value = "orderSn", required = false)String orderSn,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<CouponHistory> historyPage = historyService.list(couponId, useStatus, orderSn, current, limit);
        return new CommonResult(historyPage);
    }

}
