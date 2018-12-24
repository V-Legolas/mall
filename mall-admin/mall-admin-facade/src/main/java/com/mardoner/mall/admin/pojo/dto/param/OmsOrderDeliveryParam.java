package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @Description:  发货信息
* @ClassName: OmsOrderDeliveryParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:19
* @Version 1.0
*/
public class OmsOrderDeliveryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("物流运输单号")
    private String deliverySn;

    @ApiModelProperty("物流公司")
    private String deliveryCompany;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }
}
