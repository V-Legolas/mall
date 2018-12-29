package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.HomeRecommendProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 人气推荐商品表 mapper接口
* @className: HomeRecommendProductMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface HomeRecommendProductMapper extends BaseMapper<HomeRecommendProduct> {

    /**
     * 批量插入
     */
    int insertList(@Param("list")List<HomeRecommendProduct> recommendProductList);
}
