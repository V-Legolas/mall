package com.mardoner.mall.admin.entity.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* @Description: 商品订单 实体类
* @ClassName: OmsOrder
* @author whuan-QQ:2500119268
* @mail: mardoner12p@gmail.com
* @date 2018/12/18 14:59
* @Version 1.0
*/
@TableName("oms_order")
public class OmsOrder extends Model<OmsOrder> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户id */
    @TableField("member_id")
    private Long memberId;

    /** 优惠券 id */
    @TableField("coupon_id")
    private Long couponId;

    /** 订单编号 */
    @TableField("order_sn")
    private String orderSn;

    @TableField("create_time")
    private Date craeteTime;

    /** 客户名称 */
    @TableField("member_username")
    private String memberUsername;

    /** 总价格 */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /** 应付金额 */
    @TableField("pay_amount")
    private BigDecimal payAmount;

    /** 运费 */
    @TableField("freight_amount")
    private BigDecimal freightAmount;

    /** 促销优惠金额 */
    @TableField("promotion_amount")
    private BigDecimal promotionAmount;

    /** 积分抵扣金额 */
    @TableField("integration_amount")
    private BigDecimal integrationAmount;

    /** 优惠卷抵扣金额 */
    @TableField("coupon_amount")
    private BigDecimal couponAmount;

    /** 折扣优惠金额 */
    @TableField("discount_amount")
    private BigDecimal discountAmount;

    /** 支付方式 0未支付/1支付宝/2微信*/
    @TableField("pay_type")
    private Integer payType;

    /** 订单来源 0PC订单/1APP订单 */
    @TableField("source_type")
    private Integer sourceType;

    /** 订单状态 0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单*/
    private Integer status;

    /** 订单类型 0-正常订单/1-秒杀订单*/
    @TableField("order_type")
    private Integer orderType;

    /** 物流公司（配送方式) */
    @TableField("delivery_company")
    private String deliveryCompany;

    /** 物流编号 */
    @TableField("delivery_sn")
    private String deliverySn;

    /** 自动确认收货天数 */
    @TableField("auto_confirm_day")
    private Integer autoConfirmDay;

    /** 可获得积分数 */
    @TableField("integration")
    private Integer integration;

    /** 可获得成长值 */
    private Integer growth;

    /** 活动信息 */
    @TableField("promotion_info")
    private String promotionInfo;

    /** 发票类型 0-不开发票/1-纸质发票/2-电子发票*/
    @TableField("bill_type")
    private Integer billType;

    /** 发票抬头 */
    @TableField("bill_header")
    private String billHeader;

    /** 发票内容 */
    @TableField("bill_content")
    private String billContent;

    /** 发票接收者电话 */
    @TableField("bill_receiver_phone")
    private String billReceiverPhone;

    /** 发票邮箱 */
    @TableField("bill_receiver_email")
    private String billReceiverEmail;

    /** 订单接收人名 */
    @TableField("receiver_name")
    private String receiverName;

    /** 收货电话 */
    @TableField("receiver_phone")
    private String receiverPhone;

    /** 接收地址邮政编码 */
    @TableField("receiver_post_coe")
    private String receiverPostCode;

    /** 接收地址信息 */
    @TableField("receiver_province")
    private String receiverProvince;

    @TableField("receiver_city")
    private String receiverCity;

    @TableField("receiver_region")
    private String receiverRegion;

    @TableField("receiver_detail_address")
    private String receiverDetailAddress;

    private String note;

    /** 确认收货状态 */
    @TableField("confirm_status")
    private Integer confirmStatus;

    /** 删除状态 */
    @TableField("delete_status")
    private Integer deleteStatus;

    /** 下单使用积分 */
    @TableField("use_integration")
    private Integer useIntegration;

    /** 支付时间 */
    @TableField("payment_time")
    private Date paymentTime;

    /** 发货时间 */
    @TableField("delivery_time")
    private Date deliveryTime;

    /** 收货时间 */
    @TableField("receive_time")
    private Date receiveTime;

    /** 评论时间 */
    @TableField("comment_time")
    private Date commentTime;

    /** 修改时间 */
    @TableField("modify_time")
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getBillHeader() {
        return billHeader;
    }

    public void setBillHeader(String billHeader) {
        this.billHeader = billHeader;
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }

    public String getBillReceiverPhone() {
        return billReceiverPhone;
    }

    public void setBillReceiverPhone(String billReceiverPhone) {
        this.billReceiverPhone = billReceiverPhone;
    }

    public String getBillReceiverEmail() {
        return billReceiverEmail;
    }

    public void setBillReceiverEmail(String billReceiverEmail) {
        this.billReceiverEmail = billReceiverEmail;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
