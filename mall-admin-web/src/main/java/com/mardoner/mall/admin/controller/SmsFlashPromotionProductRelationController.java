package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.FlashPromotionProductRelation;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionProduct;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.service.sms.FlashPromotionProductRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  限时购和商品关系管理controller
* @className: SmsFlashPromotionProductRelationController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 15:51
* @version 1.0
*/
@RestController
@Api(tags = "SmsFlashPromotionProductRelationController", description="限时购和商品关系管理")
@RequestMapping("flash/product")
public class SmsFlashPromotionProductRelationController implements IController {
    @Resource(name = "flashPromotionProductRelationServiceImpl")
    private FlashPromotionProductRelationService productRelationService;

    @ApiOperation("批量添加商品关联")
    @PostMapping("/create")
    public CommonResult insertBatch(@RequestBody List<FlashPromotionProductRelation> relationList){
        int count = productRelationService.createBatch(relationList);
        return getResult(count);
    }

    @ApiOperation("修改关联信息")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FlashPromotionProductRelation relation){
        int count = productRelationService.update(id, relation);
        return getResult(count);
    }

    @ApiOperation("删除关联信息")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        int count = productRelationService.delete(id);
        return getResult(count);
    }

    @ApiOperation("获取商品关联信息")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        FlashPromotionProductRelation productRelation = productRelationService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS, productRelation);
    }

    @ApiOperation("分页查询不同场次商品关联信息")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "flashPromotionId", required = false)Long flashPromotionId,
                             @RequestParam(value = "flashPromotionSessionId", required = false)Long flashPromotionSessionId,
                             @RequestParam(value = "pageNum", defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<SmsFlashPromotionProduct> promotionPage =
                productRelationService.list(flashPromotionId, flashPromotionSessionId, current, limit);
        return new CommonResult(CommonReturnCode.SUCCESS, promotionPage);
    }
}
