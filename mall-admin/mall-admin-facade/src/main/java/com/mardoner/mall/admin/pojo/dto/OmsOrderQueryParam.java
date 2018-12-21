package com.mardoner.mall.admin.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:  订单查询条件 DTO
* @ClassName: OmsOrderQueryParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:07
* @Version 1.0
*/
public class OmsOrderQueryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("收货人姓名/手机号码")
    private String receiveNameOrPhone;

    @ApiModelProperty("订单状态：0->待付款; 1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    @ApiModelProperty("订单类型：0->正常订单；1->秒杀订单")
    private Integer type;

    @ApiModelProperty("订单来源：0->PC订单；1->APP订单")
    private Integer sourceType;

    @ApiModelProperty("订单提交时间")
    private Date createTime;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getReceiveNameOrPhone() {
        return receiveNameOrPhone;
    }

    public void setReceiveNameOrPhone(String receiveNameOrPhone) {
        this.receiveNameOrPhone = receiveNameOrPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
