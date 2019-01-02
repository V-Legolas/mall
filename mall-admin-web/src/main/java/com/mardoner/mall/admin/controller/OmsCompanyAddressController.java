package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.oms.OmsCompanyAddress;
import com.mardoner.mall.admin.service.oms.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  收货地址controller
* @className: OmsCompanyAddressController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 14:29
* @version 1.0
*/
@RestController
@Api(tags = "OmsCompanyAddressController", description="收货地址管理")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController implements IController {

    @Resource(name = "omsCompanyAddressServiceImpl")
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("列举所有收货地址")
    @GetMapping("/list/all")
    public CommonResult listAll(){
        List<OmsCompanyAddress> addressList =
                companyAddressService.list(new QueryWrapper<>());
        return new CommonResult(CommonReturnCode.SUCCESS, addressList);
    }
}
