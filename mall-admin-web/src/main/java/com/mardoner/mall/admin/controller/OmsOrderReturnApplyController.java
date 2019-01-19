package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReturnApplyQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  订单退货管理 controller
* @className: OmsOrderReturnApplyController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 15:34
* @version 1.0
*/
@RestController
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController implements IController {
    @Resource(name = "omsOrderReturnApplyServiceImpl")
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @GetMapping("/list")
    public CommonResult list(OmsReturnApplyQueryParam param,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<OmsOrderReturnApply> applyPage=
                returnApplyService.list(param,current,limit);
        return new CommonResult(applyPage);
    }

    @ApiOperation("批量删除退货申请（逻辑删除，该变申请状态为拒绝）")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids")List<Long> ids){
        int count = returnApplyService.logicDelete(ids);
        return getResult(count);
    }

    @ApiOperation("获取退货详情")
    @GetMapping("/{id}")
    public CommonResult detail(@PathVariable Long id){
        OmsOrderReturnApplyResult result = returnApplyService.getItem(id);
        return new CommonResult(CommonReturnCode.SUCCESS,result);
    }

    @ApiOperation("修改申请情况")
    @PutMapping("/update/status/{id}")
    public CommonResult updateStatus(@PathVariable Long id,
                                     @RequestBody @Validated OmsOrderReturnStatusParam param,
                                     BindingResult result){

        int count = returnApplyService.updateStatus(id,param);
        return getResult(count);
    }
}
