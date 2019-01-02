package com.mardoner.mall.admin.controller;

import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.FlashPromotionSession;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionSessionDetail;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.service.sms.FlashPromotionSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  限时购场次管理
* @className: SmsFlashPromotionSessionController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:08
* @version 1.0
*/
@RestController
@Api(tags = "SmsFlashPromotionSessionController", description = "限时购场次管理")
@RequestMapping("/flash/session")
public class SmsFlashPromotionSessionController implements IController {
    @Resource(name = "flashPromotionSessionServiceImpl")
    private FlashPromotionSessionService flashSessionService;

    @ApiOperation("添加场次")
    @PostMapping("/create")
    public CommonResult create(@RequestBody FlashPromotionSession param){
        int count = flashSessionService.create(param);
        return getResult(count);
    }

    @ApiOperation("修改场次信息")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody FlashPromotionSession param){
        int count = flashSessionService.update(id, param);
        return getResult(count);
    }

    @ApiOperation("修改启用状态")
    @PutMapping("/update/status/{id}")
    public CommonResult updateUseStatus(@PathVariable Long id,
                                        Integer status){
        int count = flashSessionService.updateStatus(id,status);
        return getResult(count);
    }

    @ApiOperation("删除场次")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        int count = flashSessionService.delete(id);
        return getResult(count);
    }

    @ApiOperation("获取场次详情")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id){
        FlashPromotionSession session = flashSessionService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS, session);
    }

    @ApiOperation("获取全部场次")
    @GetMapping("/listAll")
    public CommonResult listAll(){
        List<FlashPromotionSession> sessionList = flashSessionService.list();
        return new CommonResult(CommonReturnCode.SUCCESS, sessionList);
    }

    @ApiOperation("获取全部可选场次及其数量")
    @GetMapping("/selectList")
    public CommonResult list(@RequestParam("flashPromotionId") Long flashPromotionId){
        List<SmsFlashPromotionSessionDetail> detailList =
                flashSessionService.selectList(flashPromotionId);
        return new CommonResult(CommonReturnCode.SUCCESS, detailList);
    }

}
