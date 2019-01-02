package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.FlashPromotion;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.service.sms.FlashPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @description:  限时购活动管理
* @className: SmsFlashPromotionController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 15:35
* @version 1.0
*/
@RestController
@Api(tags = "SmsFlashPromotionController", description = "限时购活动管理")
@RequestMapping("/flash")
public class SmsFlashPromotionController implements IController {
    @Resource(name = "flashPromotionServiceImpl")
    private FlashPromotionService flashPromotionService;

    @ApiOperation("添加活动")
    @PostMapping("/create")
    public CommonResult create(@RequestBody FlashPromotion param){
        int count = flashPromotionService.create(param);
        return getResult(count);
    }

    @ApiOperation("编辑活动")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody FlashPromotion param){
        int count = flashPromotionService.update(id, param);
        return getResult(count);
    }

    @ApiOperation("删除活动")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        int count = flashPromotionService.delete(id);
        return getResult(count);
    }

    @ApiOperation("修改上下线活动状态")
    @PutMapping("/update/status/{id}")
    public CommonResult update(@PathVariable Long id, Integer status){
        int count = flashPromotionService.updateStatus(id, status);
        return getResult(count);
    }

    @ApiOperation("获取活动详情")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        FlashPromotion promotion = flashPromotionService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS,promotion);
    }

    @ApiOperation(value = "分页获取活动",notes = "keyword为title查询关键字")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "keyword",required = false)String title,
                             @RequestParam(value = "pageNum", defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<FlashPromotion> page = flashPromotionService.list(title, current, limit);
        return new CommonResult(page);
    }
}
