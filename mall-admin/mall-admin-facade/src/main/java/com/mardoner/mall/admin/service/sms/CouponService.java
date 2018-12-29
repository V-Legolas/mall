package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.Coupon;
import com.mardoner.mall.admin.pojo.dto.param.SmsCouponParam;
import org.springframework.transaction.annotation.Transactional;

/**
* @description: 优惠券管理 服务逻辑接口
* @className: CouponService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:34
* @version 1.0
*/
public interface CouponService {

    /**
     * 创建优惠券
     * @param param 优惠券信息参数
     * @return 成功记录数
     */
    @Transactional
    int create(SmsCouponParam param);

    /**
     * 更新优惠券
     * @param id 优惠券id
     * @param param 信息参数
     * @return 操作影响记录数
     */
    @Transactional
    int update(Long id, SmsCouponParam param);

    /**
     * 根据id删除单挑
     * @param id 优惠券主键id
     * @return 操作影响记录数
     */
    @Transactional
    int delete(Long id);

    /**
     * 根据条件及分页信息查询
     * @param name 名称或者优惠码
     * @param type 类型
     * @param current 当前页
     * @param limit 每页显示记录数
     * @return
     */
    IPage<Coupon> list(String name, Integer type, Integer current, Integer limit);

    /**
     * 根据id获取详细信息
     * @param id 优惠卷主键id
     * @return 优惠卷详细参数信息
     */
    SmsCouponParam getItem(Long id);
}
