package com.mardoner.mall.admin.pojo.dto.param;

import com.mardoner.mall.admin.entity.sms.Coupon;
import com.mardoner.mall.admin.entity.sms.CouponProductCategoryRelation;
import com.mardoner.mall.admin.entity.sms.CouponProductRelation;

import java.util.List;

/**
* @description:  优惠券信息封装，包括绑定订单和分裂
* @className: SmsCouponParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:37
* @version 1.0
*/
public class SmsCouponParam extends Coupon {
    // 优惠券绑定的商品
    private List<CouponProductRelation> productRelationList;
    // 绑定的商品分类
    private List<CouponProductCategoryRelation> productCategoryRelationList;

    public List<CouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<CouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<CouponProductCategoryRelation> getProductCategoryRelationList() {
        return productCategoryRelationList;
    }

    public void setProductCategoryRelationList(List<CouponProductCategoryRelation> productCategoryRelationList) {
        this.productCategoryRelationList = productCategoryRelationList;
    }
}
