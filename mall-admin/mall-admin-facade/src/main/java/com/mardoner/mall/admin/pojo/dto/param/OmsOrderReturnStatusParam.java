package com.mardoner.mall.admin.pojo.dto.param;

import com.mardoner.mall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @Description:  订单售后状态参数 DTO
* @ClassName: OmsOrderReturnStatusParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 19:24
* @Version 1.0
*/
public class OmsOrderReturnStatusParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("退货地址关联id")
    private Long companyAddressId;

    @ApiModelProperty("确认退货金额")
    private Double returnAmount;

    @ApiModelProperty("处理备注")
    private String handleNote;

    @ApiModelProperty("处理人")
    private String handleMan;

    @ApiModelProperty("收货备注")
    private String receiveNote;

    @ApiModelProperty("收货人")
    private String receiveMan;

    @ApiModelProperty("申请状态(1->退货中/2->已完成/3->拒绝退货)")
    @FlagValidator({"0","1","2","3"})
    private Integer status;

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public Double getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Double returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
