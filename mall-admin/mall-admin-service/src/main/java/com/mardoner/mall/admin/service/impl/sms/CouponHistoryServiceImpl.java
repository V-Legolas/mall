package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.CouponHistory;
import com.mardoner.mall.admin.mapper.sms.CouponHistoryMapper;
import com.mardoner.mall.admin.service.sms.CouponHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @description:  优惠券记录
* @className: CouponHistoryServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/28 21:40
* @version 1.0
*/
@Service
public class CouponHistoryServiceImpl implements CouponHistoryService {

    @Resource(name = "couponHistoryMapper")
    private CouponHistoryMapper couponHistoryMapper;


    @Override
    public IPage<CouponHistory> list(Long couponId, Integer useStatus, String orderSn,
                                     Integer current, Integer limit) {
        IPage<CouponHistory> page = new Page<>(current, limit);
        // 查询实体
        CouponHistory queryEntity = new CouponHistory();
        queryEntity.setCouponId(couponId);
        queryEntity.setUseStatus(useStatus);
        QueryWrapper<CouponHistory> wrapper = new QueryWrapper<>(queryEntity);
        if(!StringUtils.isEmpty(orderSn)){
            wrapper.like("order_sn",orderSn);
        }
        return couponHistoryMapper.selectPage(page,wrapper);
    }
}
