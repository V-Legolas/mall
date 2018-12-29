package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.Coupon;
import com.mardoner.mall.admin.pojo.dto.param.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
* @description: 优惠卷表 mapper接口
* @className: CouponMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface CouponMapper extends BaseMapper<Coupon> {

    /**
     * 根据优惠券Id获取优惠券详细信息，及其与商品和商品分类关联
     * @param couponId 优惠券id
     * @return
     */
    SmsCouponParam getItem(@Param("id") Long couponId);
}
