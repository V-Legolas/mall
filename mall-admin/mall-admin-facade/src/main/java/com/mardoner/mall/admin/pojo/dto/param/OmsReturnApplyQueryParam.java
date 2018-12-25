package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @description:  订单退货申请 分页查询入参
* @className: OmsReturnApplyQueryParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 15:55
* @version 1.0
*/
@ApiModel("订单退货申请 分页查询入参")
public class OmsReturnApplyQueryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("服务单号")
    private Long id;

    @ApiModelProperty("收货人姓名/号码")
    private String nameOrPhone;

    @ApiModelProperty("审核状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    private Integer status;

    @ApiModelProperty("申请时间")
    private String createTime;

    @ApiModelProperty("处理人员")
    private String handleMan;

    @ApiModelProperty("处理时间")
    private String handleTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOrPhone() {
        return nameOrPhone;
    }

    public void setNameOrPhone(String nameOrPhone) {
        this.nameOrPhone = nameOrPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }
}
