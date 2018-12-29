package com.mardoner.mall.admin.pojo.dto.vo;

import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.entity.sms.FlashPromotionProductRelation;

/**
* @description:  限时购及商品信息封装
* @className: SmsFlashPromotionProduct
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:41
* @version 1.0
*/
public class SmsFlashPromotionProduct extends FlashPromotionProductRelation {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
