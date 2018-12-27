package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.common.util.SingletonLoginUtils;
import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.pojo.dto.param.OmsMoneyParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderDeliveryParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderQueryParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReceiveInfoParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderDetail;
import com.mardoner.mall.admin.service.oms.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  订单管理 controller
* @className: OmsOrderController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 14:37
* @version 1.0
*/
@Api(tags = "OmsOrderController", description="订单管理")
@RestController
@RequestMapping("/order")
public class OmsOrderController implements IController {

    @Resource(name = "omsOrderServiceImpl")
    private OmsOrderService orderService;

    @ApiOperation(value = "分页、条件查找订单",notes = "第一个参数封装查询条件")
    @GetMapping("/list")
    public AdminResult list(OmsOrderQueryParam queryParam,
                     @RequestParam(value = "pageSize", defaultValue = "5")Integer limit,
                     @RequestParam(value = "pageNum", defaultValue = "1")Integer current){
        IPage<OmsOrder> orderPage = orderService.getList(queryParam,current,limit);
        return new AdminResult(orderPage);
    }

    @ApiOperation("批量发货")
    @PutMapping("/update/delivery")
    public AdminResult delivery(@RequestBody List<OmsOrderDeliveryParam> params){
        int count = orderService.delivery(params, SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

    @ApiOperation("批量关闭订单")
    @PutMapping("/update/close")
    public AdminResult close(@RequestParam("ids") List<Long> ids,
                             @RequestParam(value = "note", defaultValue = "") String note){
        int count = orderService.close(ids,note,SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

    @ApiOperation("批量删除订单(逻辑删除)")
    @DeleteMapping("/delete")
    public AdminResult loginDelete(@RequestParam("ids") List<Long> ids){
        int count = orderService.delete(ids);
        return getAdminResult(count);
    }

    @ApiOperation("获取订单详情：订单信息，商品信息，操作记录")
    @GetMapping("/{id}")
    public AdminResult detailById(@PathVariable Long id){
        OmsOrderDetail detail = orderService.detail(id);
        return new AdminResult(CommonReturnCode.SUCCESS, detail);
    }

    @ApiOperation("修改收货人信息")
    @PutMapping("/update/receiverInfo")
    public AdminResult updateReceiverInfo(@RequestBody @Validated OmsReceiveInfoParam param,
                                          BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = orderService.updateReceiveInfo(param,SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

    @ApiOperation("修改订单费用信息")
    @PutMapping("/update/moneyInfo")
    public AdminResult updateMoneyInfo(@RequestBody @Validated OmsMoneyParam param,
                                       BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        int count = orderService.updateMoneyInfo(param,SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

    @ApiOperation("备注订单")
    @PutMapping("/{id}/updateNote")
    public AdminResult updateNote(@PathVariable Long id,
                                  @RequestParam("note")String note,
                                  @RequestParam("status")Integer status){
        int count = orderService.updateNote(id,note,status,
                SingletonLoginUtils.getUsername());
        return getAdminResult(count);
    }

}
