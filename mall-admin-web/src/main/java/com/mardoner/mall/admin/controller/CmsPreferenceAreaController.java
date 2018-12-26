package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.cms.CmsPreferenceArea;
import com.mardoner.mall.admin.service.cms.CmsPreferenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品优选管理controller
* @className: CmsPreferenceAreaController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 14:04
* @version 1.0
*/
@RestController
@Api(tags = "CmsPreferenceAreaController", description = "商品优选管理")
@RequestMapping("/preference/area")
public class CmsPreferenceAreaController implements IController {

    @Resource(name = "cmsPreferenceAreaServiceImpl")
    private CmsPreferenceAreaService preferenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/list/all")
    public AdminResult listAll(){
        List<CmsPreferenceArea> preferenceAreaList =
                preferenceAreaService.list(new QueryWrapper<>());
        return new AdminResult(CommonReturnCode.SUCCESS, preferenceAreaList);
    }
}
