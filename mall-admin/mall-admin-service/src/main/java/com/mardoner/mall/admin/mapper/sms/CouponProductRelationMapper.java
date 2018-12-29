package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.CouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 优惠券和产品的关系表 mapper接口
* @className: CouponProductRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface CouponProductRelationMapper extends BaseMapper<CouponProductRelation> {

    /**
     * 批量插入
     */
    int insertList(@Param("list") List<CouponProductRelation> relationList);
}
