package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.HomeRecommendSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 首页推荐专题表 mapper接口
* @className: HomeRecommendSubjectMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface HomeRecommendSubjectMapper extends BaseMapper<HomeRecommendSubject> {


    /**
     * 批量插入
     */
    int insertList(@Param("list")List<HomeRecommendSubject> subjectList);
}
