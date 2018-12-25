package com.mardoner.mall.admin.controller;

import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.oms.OmsOrderSetting;
import com.mardoner.mall.admin.service.oms.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @description:  订单相关设置 controller
* @className: OmsOrderSettingController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 17:07
* @version 1.0
*/
@RestController
@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@RequestMapping("/order/setting")
public class OmsOrderSettingController implements IController {
    @Resource(name = "omsOrderSettingServiceImpl")
    private OmsOrderSettingService settingService;

    @ApiOperation("获取指定订单设置")
    @GetMapping("/{id}")
    public AdminResult getItem(@PathVariable Long id){
        OmsOrderSetting setting = settingService.getById(id);
        return new AdminResult(CommonReturnCode.SUCCESS, setting);
    }

    @ApiOperation("更新指定订单设置")
    @PutMapping("/update/{id}")
    public AdminResult update(@PathVariable Long id,
                              @RequestBody OmsOrderSetting setting){
        setting.setId(id);
        boolean isOk = settingService.updateById(setting);
        return getAdminResult(isOk);
    }

}
