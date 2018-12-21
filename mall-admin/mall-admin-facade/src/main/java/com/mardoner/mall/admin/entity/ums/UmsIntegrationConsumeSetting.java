package com.mardoner.mall.admin.entity.ums;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 积分消费设置
* @ClassName: UmsIntegrationConsumeSetting
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 17:00
* @Version 1.0
*/
@TableName("ums_integration_consume_setting")
public class UmsIntegrationConsumeSetting extends Model<UmsIntegrationConsumeSetting> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 一元抵扣积分数量 */
    @TableField("deduction_per_amount")
    private Integer deductionPerAmount;

    /** 每笔订单最高抵扣百分比 */
    @TableField("max_percent_per_order")
    private Integer maxPercentPerOrder;

    /** 每次积分使用最小单位 100 */
    @TableField("use_unit")
    private Integer useUnit;

    /** 是否可以和优惠券同时使用 0不可以、1可以*/
    @TableField("coupon_status")
    private Integer couponStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeductionPerAmount() {
        return deductionPerAmount;
    }

    public void setDeductionPerAmount(Integer deductionPerAmount) {
        this.deductionPerAmount = deductionPerAmount;
    }

    public Integer getMaxPercentPerOrder() {
        return maxPercentPerOrder;
    }

    public void setMaxPercentPerOrder(Integer maxPercentPerOrder) {
        this.maxPercentPerOrder = maxPercentPerOrder;
    }

    public Integer getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(Integer useUnit) {
        this.useUnit = useUnit;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
