package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.CouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 优惠券和产品分类关系表 mapper接口
* @className: CouponProductCategoryRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface CouponProductCategoryRelationMapper extends BaseMapper<CouponProductCategoryRelation> {

    /**
     * 批量插入
     * @param relationList
     * @return
     */
    int insertList(@Param("list") List<CouponProductCategoryRelation> relationList);
}
