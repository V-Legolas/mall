package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
* @Description:  订单收货信息参数对象
* @ClassName: OmsReceiveInfoParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:28
* @Version 1.0
*/
public class OmsReceiveInfoParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long id;
    @ApiModelProperty("接收人")
    private String receiverName;
    @ApiModelProperty("手机号码")
    @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$",message = "手机号码格式不正确")
    private String receiverPhone;
    @ApiModelProperty("邮政编码")
    @Pattern(regexp = "^\\d{6}$",message = "邮政编码格式不正确")
    private String receiverPostCode;
    @ApiModelProperty("省")
    private String receiverProvince;
    @ApiModelProperty("市/县")
    private String receiverCity;
    @ApiModelProperty("街道、区县")
    private String receiverRegion;
    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;
    @ApiModelProperty("收货地址是否有效")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
