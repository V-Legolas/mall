package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.Coupon;
import com.mardoner.mall.admin.pojo.dto.param.SmsCouponParam;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.service.sms.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @description:  优惠券 视图层
* @className: SmsCouponController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 14:36
* @version 1.0
*/
@RestController
@Api(tags = "SmsCouponController", description = "优惠券管理")
@RequestMapping("/coupon")
public class SmsCouponController implements IController {

    @Resource(name = "couponServiceImpl")
    private CouponService couponService;

    @ApiOperation("添加优惠券")
    @PostMapping("/create")
    public CommonResult create(@RequestBody SmsCouponParam param){
        int count = couponService.create(param);
        return getResult(count);
    }

    @ApiOperation("删除优惠券")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        int count = couponService.delete(id);
        return getResult(count);
    }

    @ApiOperation("修改优惠券")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody SmsCouponParam param){
        int count = couponService.update(id,param);
        return getResult(count);
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "name",required = false)String name,
                             @RequestParam(value = "type", required = false)Integer type,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<Coupon> pageResult = couponService.list(name,type,current,limit);
        return new CommonResult(pageResult);
    }

    @ApiOperation("获取单个优惠券详细信息")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        return new CommonResult(CommonReturnCode.SUCCESS, couponService.getItem(id));
    }
}
