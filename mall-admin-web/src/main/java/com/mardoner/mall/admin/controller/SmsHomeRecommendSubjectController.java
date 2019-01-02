package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.HomeRecommendSubject;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.service.sms.HomeRecommendSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  首页专题推荐
* @className: SmsHomeRecommendSubjectController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:39
* @version 1.0
*/
@RestController
@Api(tags = "SmsHomeRecommendSubjectController", description = "首页专题推荐管理")
@RequestMapping("/home/recommendSubject")
public class SmsHomeRecommendSubjectController implements IController {
    @Resource(name = "homeSubjectServiceImpl")
    private HomeRecommendSubjectService subjectService;

    @ApiOperation("批量添加首页推荐专题")
    @PostMapping("/create")
    public CommonResult insertBatch(@RequestBody List<HomeRecommendSubject> subjectList){
        int count = subjectService.create(subjectList);
        return getResult(count);
    }

    @ApiOperation("批量修改专题排序")
    @PutMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id, Integer sort){
        int count = subjectService.updateSort(id, sort);
        return getResult(count);
    }

    @ApiOperation("批量修改专题推荐状态")
    @PutMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus){
        int count = subjectService.updateRecommendStatus(ids, recommendStatus);
        return getResult(count);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/delete")
    public CommonResult deleteBatch(@RequestParam("ids")List<Long> ids){
        int count = subjectService.deleteBatch(ids);
        return getResult(count);
    }

    @ApiOperation(value = "分页查询首页推荐专题", notes = "'subjectName': 专题名称模糊查询，'recommendStatus': 推荐状态")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "subjectName", required = false)String subjectName,
                             @RequestParam(value = "recommendStatus", required = false)Integer recommendStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "5")Integer limit){
        IPage<HomeRecommendSubject> subjectPage =
                subjectService.list(subjectName, recommendStatus, current, limit);
        return new CommonResult(subjectPage);
    }
}
