package com.mardoner.mall.admin.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @Description:  订单费用信息
* @ClassName: OmsMoneyInfo
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:36
* @Version 1.0
*/
public class OmsMoneyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("物流费用")
    private Double freightAmount;
    @ApiModelProperty("折扣费用")
    private Double discountAmount;
    @ApiModelProperty("订单状态")
    private Integer status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
