package com.mardoner.mall.admin.controller;

import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.ums.UmsMemberLevel;
import com.mardoner.mall.admin.service.ums.UmsMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  会员等级管理
* @ClassName: UmsMemberLevelController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 20:35
* @Version 1.0
*/
@RestController
@Api(tags = "UmsMemberLevelController",description = "会员等级管理")
@RequestMapping("/memberLevel")
public class UmsMemberLevelController implements IController {

    @Resource(name = "umsMemberLevelServiceImpl")
    private UmsMemberLevelService memberLevelService;

    @ApiOperation("获取所有会员等级状态（根据defaultStatus,1为普通会员）")
    @GetMapping("/list")
    public AdminResult list(@RequestParam("defaultStatus") Integer status){
        List<UmsMemberLevel> memberList = memberLevelService.list(status);
        return new AdminResult(CommonReturnCode.SUCCESS,memberList);
    }
}
