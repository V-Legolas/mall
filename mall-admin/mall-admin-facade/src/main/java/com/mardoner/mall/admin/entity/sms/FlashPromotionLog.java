package com.mardoner.mall.admin.entity.sms;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
* @description: 限时购通知记录 mapper接口
* @className: FlashPromotionLog
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
@TableName("sms_flash_promotion_log")
public class FlashPromotionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer memberId;

    private Long productId;

    private String memberPhone;

    private String productName;

    /**
     * 会员订阅时间
     */
    private LocalDateTime subscribeTime;

    private LocalDateTime sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public LocalDateTime getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(LocalDateTime subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "FlashPromotionLog{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", productId=" + productId +
        ", memberPhone=" + memberPhone +
        ", productName=" + productName +
        ", subscribeTime=" + subscribeTime +
        ", sendTime=" + sendTime +
        "}";
    }
}
