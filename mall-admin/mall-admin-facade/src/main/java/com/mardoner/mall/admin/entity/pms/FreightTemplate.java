package com.mardoner.mall.admin.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* @Description:  物流费用模板  实体类
* @ClassName: FreightTemplate
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 16:56
* @Version 1.0
*/
@TableName("pms_freight_template")
public class FreightTemplate extends Model<FreightTemplate> {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    /** 计费类型：0->计重；1->计件 */
    @TableField("charge_type")
    private Integer chargeType;

    /** 首重 */
    @TableField("first_weight")
    private BigDecimal firstWeight;

    /** 首费 */
    @TableField("first_fee")
    private BigDecimal firstFee;

    /** 超过首重计价方式 */

    @TableField("continue_weight")
    private BigDecimal continueWeight;

    @TableField("continue_fee")
    private BigDecimal continue_fee;

    /** 目的地 */
    private String dest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstFee() {
        return firstFee;
    }

    public void setFirstFee(BigDecimal firstFee) {
        this.firstFee = firstFee;
    }

    public BigDecimal getContinueWeight() {
        return continueWeight;
    }

    public void setContinueWeight(BigDecimal continueWeight) {
        this.continueWeight = continueWeight;
    }

    public BigDecimal getContinue_fee() {
        return continue_fee;
    }

    public void setContinue_fee(BigDecimal continue_fee) {
        this.continue_fee = continue_fee;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
