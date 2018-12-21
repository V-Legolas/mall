package com.mardoner.mall.admin.entity.ums;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 会员积分成长规则
* @ClassName: UmsMemberRuleSetting
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 18:36
* @Version 1.0
*/
@TableName("ums_member_rule_setting")
public class UmsMemberRuleSetting extends Model<UmsMemberRuleSetting> {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 连续签到天数 */
    @TableField("continue_sign_day")
    private Integer continueSignDay;

    /** 连续签到获取点数 */
    @TableField("continue_sign_point")
    private Integer continueSignPoint;

    @TableField("consume_per_point")
    private Double consumePerPoint;

    /** 最低获取点数的订单金额 */
    @TableField("low_order_amount")
    private Double lowOrderAmount;

    /** 每笔订单最高获取点数 */
    @TableField("max_point_per_order")
    private Integer maxPointPerOrder;

    /** 类型 0->积分制/1->成长值规则 */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContinueSignDay() {
        return continueSignDay;
    }

    public void setContinueSignDay(Integer continueSignDay) {
        this.continueSignDay = continueSignDay;
    }

    public Integer getContinueSignPoint() {
        return continueSignPoint;
    }

    public void setContinueSignPoint(Integer continueSignPoint) {
        this.continueSignPoint = continueSignPoint;
    }

    public Double getConsumePerPoint() {
        return consumePerPoint;
    }

    public void setConsumePerPoint(Double consumePerPoint) {
        this.consumePerPoint = consumePerPoint;
    }

    public Double getLowOrderAmount() {
        return lowOrderAmount;
    }

    public void setLowOrderAmount(Double lowOrderAmount) {
        this.lowOrderAmount = lowOrderAmount;
    }

    public Integer getMaxPointPerOrder() {
        return maxPointPerOrder;
    }

    public void setMaxPointPerOrder(Integer maxPointPerOrder) {
        this.maxPointPerOrder = maxPointPerOrder;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
