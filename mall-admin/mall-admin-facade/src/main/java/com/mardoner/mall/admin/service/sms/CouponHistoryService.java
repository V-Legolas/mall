package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.CouponHistory;

/**
* @description:  优惠卷领取记录 service
* @className: CouponHistoryService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:51
* @version 1.0
*/
public interface CouponHistoryService {
    /**
     * 分页查询 优惠卷领取记录
     * @param couponId 优惠卷id
     * @param useStatus 使用状态
     * @param orderSn 使用的订单id
     * @param current 当前页
     * @param limit 每页显示记录数
     * @return 返回领取记录信息
     */
    IPage<CouponHistory> list(Long couponId, Integer useStatus, String orderSn,
                              Integer current, Integer limit);
}
