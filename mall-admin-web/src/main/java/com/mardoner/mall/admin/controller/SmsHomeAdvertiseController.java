package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.HomeAdvertise;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.service.sms.HomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  主页广告管理 controller
* @className: SmsHomeAdvertiseController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:15
* @version 1.0
*/
@RestController
@Api(tags = "SmsHomeAdvertiseController", description = "主页广告管理")
@RequestMapping("/home/advertise")
public class SmsHomeAdvertiseController implements IController {
    @Resource(name = "homeAdvertiseServiceImpl")
    private HomeAdvertiseService advertiseService;

    @ApiOperation("在主页添加广告")
    @PostMapping("/create")
    public CommonResult create(@RequestBody HomeAdvertise advertise){
        int count = advertiseService.create(advertise);
        return getResult(count);
    }

    @ApiOperation("修改主页广告上下线状态")
    @PutMapping("/update/status/{id}")
    public CommonResult updateRecommendStatus(@PathVariable Long id,
                                              @RequestParam("recommendStatus")Integer recommendStatus){
        int count = advertiseService.updateStatus(id,recommendStatus);
        return getResult(count);
    }

    @ApiOperation("修改广告")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody HomeAdvertise advertise){
        int count = advertiseService.update(id,advertise);
        return getResult(count);
    }

    @ApiOperation("删除广告")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = advertiseService.delete(ids);
        return getResult(count);
    }

    @ApiOperation("获取广告详情")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        HomeAdvertise advertise = advertiseService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS, advertise);
    }

    @ApiOperation(value = "分页查询广告",notes = "'name'参数为模糊查询广告名称，'type'广告类型，'endTime'广告结束日期，格式为'xxxx-xx'")
    @GetMapping("list")
    public CommonResult list(String name, Integer type, String endTime,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<HomeAdvertise> page = advertiseService.list(name,type,endTime,current,limit);
        return new CommonResult(CommonReturnCode.SUCCESS, page);
    }

}
