package com.mardoner.mall.admin.pojo.dto.param;

import com.mardoner.mall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* @Description:  订单费用信息
* @ClassName: OmsMoneyParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:36
* @Version 1.0
*/
@ApiModel("订单费用信息")
public class OmsMoneyParam implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("物流费用")
    private BigDecimal freightAmount;
    @ApiModelProperty("折扣费用")
    private BigDecimal discountAmount;
    @ApiModelProperty("订单状态")
    @FlagValidator(value = {"0","1","2","3","4","5"})
    private Integer status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
