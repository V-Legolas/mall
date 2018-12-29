package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.FlashPromotion;

/**
* @description:  限时购活动管理
* @className: FlashPromotionService
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 19:04
* @version 1.0
*/
public interface FlashPromotionService {

    int create(FlashPromotion param);

    int update(Long id, FlashPromotion param);

    int delete(Long id);

    FlashPromotion getById(Long id);

    /**
     * 修改上下线状态
     */
    int updateStatus(Long id,Integer status);

    /**
     * 分页查询活动
     */
    IPage<FlashPromotion> list(String keyword, Integer current, Integer limit);

}
