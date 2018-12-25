package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.entity.cms.CmsSubject;
import com.mardoner.mall.admin.service.cms.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  商品专题管理 controller
* @className: CmsSubjectController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 14:10
* @version 1.0
*/
@RestController
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController implements IController {

    @Resource(name = "cmsSubjectServiceImpl")
    private CmsSubjectService subjectService;

    @ApiOperation("列举所有专题")
    @GetMapping("/list/all")
    public AdminResult listAll(){
        List<CmsSubject> subjectList = subjectService.list(new QueryWrapper<>());
        return new AdminResult(CommonReturnCode.SUCCESS, subjectList);
    }

    @ApiOperation("根据关键字（专题主题）以及分页信息列举专题信息")
    @GetMapping("/list")
    public AdminResult list(@RequestParam(value = "keyword", required = false)String keyword,
                            @RequestParam(value = "pageNum", defaultValue = "1")Integer current,
                            @RequestParam(value = "pageSize", defaultValue = "5")Integer size){
        IPage<CmsSubject> page = new Page<>(current,size);
        QueryWrapper<CmsSubject> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)){
            wrapper.like("title",keyword);
        }
        subjectService.page(page,wrapper);
        return new AdminResult(page);

    }
}
