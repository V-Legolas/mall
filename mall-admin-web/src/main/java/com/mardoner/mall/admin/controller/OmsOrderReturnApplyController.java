package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReturnApplyQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public AdminResult list(@RequestParam("keyword")OmsReturnApplyQueryParam param,
                            @RequestParam("pageNum")Integer current,
                            @RequestParam("pageSize")Integer limit){
        IPage<OmsOrderReturnApply> applyPage=
                returnApplyService.list(param,current,limit);
        return new AdminResult(applyPage);
    }

    @ApiOperation("批量删除退货申请（逻辑删除，该变申请状态为拒绝）")
    @DeleteMapping("/delete")
    public AdminResult delete(List<Long> ids){
        int count = returnApplyService.logicDelete(ids);
        return getAdminResult(count);
    }

    @ApiOperation("获取退货详情")
    @GetMapping("/{id}")
    public AdminResult detail(@PathVariable Long id){
        OmsOrderReturnApplyResult result = returnApplyService.getItem(id);
        return new AdminResult(CommonReturnCode.SUCCESS,result);
    }

    @ApiOperation("修改申请情况")
    @PutMapping("/update/status/{id}")
    public AdminResult updateStatus(@PathVariable Long id,
                                    @RequestBody OmsOrderReturnStatusParam param){
        int count = returnApplyService.updateStatus(id,param);
        return getAdminResult(count);
    }
}
