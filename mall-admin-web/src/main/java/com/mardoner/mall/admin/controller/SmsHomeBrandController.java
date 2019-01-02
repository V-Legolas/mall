package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.entity.sms.HomeBrand;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.service.sms.HomeBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  首页品牌管理
* @className: SmsHomeBrandController
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/2 16:21
* @version 1.0
*/
@RestController
@Api(tags = "SmsHomeBrandController", description = "首页品牌管理")
@RequestMapping("/home/brand")
public class SmsHomeBrandController implements IController {
    @Resource(name = "homeBrandServiceImpl")
    private HomeBrandService brandService;

    @ApiOperation("添加主页推荐品牌")
    @PostMapping("/create")
    public CommonResult create(@RequestBody List<HomeBrand> brandList){
        int count = brandService.create(brandList);
        return getResult(count);
    }

    @ApiOperation("批量删除主页推荐品牌")
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = brandService.deleteBatch(ids);
        return getResult(count);
    }

    @ApiOperation("修改品牌排序")
    @PutMapping("/update/sort/{id}")
    public CommonResult updateSort(@PathVariable Long id,Integer sort){
        int count = brandService.updateSort(id, sort);
        return getResult(count);
    }

    @ApiOperation("批量修改推荐状态")
    @PutMapping("/update/recommendStatus")
    public CommonResult updateRecommendStatus(@RequestParam("ids")List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus){
        int count = brandService.updateRecommendStatus(ids, recommendStatus);
        return getResult(count);
    }

    @ApiOperation(value = "分页查询推荐品牌", notes = "'brandName'模糊查询品牌名称，'recommendStatus'推荐状态")
    @GetMapping("/list")
    public CommonResult list(String brandName,Integer recommendStatus,
                             @RequestParam(value = "pageNum",defaultValue = "1")Integer current,
                             @RequestParam(value = "pageSize", defaultValue = "5")Integer limit){
        IPage<HomeBrand> brandPage =
                brandService.list(brandName, recommendStatus, current, limit);
        return new CommonResult(brandPage);
    }
}

