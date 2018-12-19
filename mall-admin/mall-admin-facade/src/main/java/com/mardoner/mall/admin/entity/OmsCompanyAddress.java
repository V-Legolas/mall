package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 公司收发货地址表 实体类
* @ClassName: OmsCompanyAddress
* @author whuan-QQ:2500119268
* @mail: mardoner12p@gmail.com
* @date 2018/12/18 14:59
* @Version 1.0
*/
@TableName("oms_company_address")
public class OmsCompanyAddress extends Model<OmsCompanyAddress> {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /** 地址名称 */
    @TableField("address_name")
    private String addressName;

    /** 发货状态 */
    @TableField("send_status")
    private Integer sendStatus;

    /** 收货状态 */
    @TableField("receive_status")
    private Integer receiveStatus;

    private String name;

    private String phone;

    private String province;

    private String city;

    /** 镇或者区 */
    private String region;

    /** 详细地址 */
    @TableField("detail_address")
    private String detailAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
