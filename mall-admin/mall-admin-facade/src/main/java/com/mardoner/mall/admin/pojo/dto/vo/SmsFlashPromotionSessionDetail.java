package com.mardoner.mall.admin.pojo.dto.vo;

import com.mardoner.mall.admin.entity.sms.FlashPromotionSession;

/**
* @description:  包含商品数量的场次信息
* @className: SmsFlashPromotionSessionDetail
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:43
* @version 1.0
*/
public class SmsFlashPromotionSessionDetail extends FlashPromotionSession {
    private Integer productCount;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
