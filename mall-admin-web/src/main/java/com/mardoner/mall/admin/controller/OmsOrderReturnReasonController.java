package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnReason;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  退货原因
* @className: OmsOrderReturnReasonController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 16:28
* @version 1.0
*/
@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@RestController
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController implements IController {

    @Resource(name = "omsOrderReturnReasonServiceImpl")
    private OmsOrderReturnReasonService returnReasonService;

    @ApiOperation("添加退货原因")
    @PostMapping("/create")
    public AdminResult create(@RequestBody @Validated OmsOrderReturnReason reason,
                              BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        boolean isOk = returnReasonService.save(reason);
        return getAdminResult(isOk);
    }

    @ApiOperation("修改单条退货原因")
    @PutMapping("/update/{id}")
    public AdminResult update(@PathVariable Long id,
                              @RequestBody @Validated OmsOrderReturnReason returnReason,
                              BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        returnReason.setId(id);
        boolean isOk = returnReasonService.updateById(returnReason);
        return getAdminResult(isOk);
    }

    @ApiOperation("批量删除退货原因")
    @DeleteMapping("/delete")
    public AdminResult delete(@RequestParam("ids")List<Long> ids){
        boolean isOk = returnReasonService.removeByIds(ids);
        return getAdminResult(isOk);
    }

    @ApiOperation("分页查询全部退货原因")
    @GetMapping("/list")
    public AdminResult list(@RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                            @RequestParam(value =  "pageSize", defaultValue = "5")Integer limit){
        IPage<OmsOrderReturnReason> page = new Page<>(current,limit);
        returnReasonService.page(page,new QueryWrapper<>());
        return new AdminResult(page);
    }

    @ApiOperation("获取单个退货原因详情")
    @GetMapping("/{id}")
    public AdminResult getItem(@PathVariable Long id){
        OmsOrderReturnReason reason = returnReasonService.getById(id);
        return new AdminResult(CommonReturnCode.SUCCESS,reason);
    }

    @ApiOperation("批量修改退货原因 是否启用")
    @PutMapping("/update/status")
    public AdminResult updateStatus(@RequestParam("ids")List<Long> ids,
                                    @RequestParam("status") Integer status){
        int count = returnReasonService.updateStatus(ids,status);
        return getAdminResult(count);
    }
}
