package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 订单中包含的商品 实体类
* @ClassName: OmsOrderItem
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 15:46
* @Version 1.0
*/
@TableName("oms_order_item")
public class OmsOrderItem extends Model<OmsOrderItem> {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("order_id")
    private Long orderId;

    @TableField("product_id")
    private Long productId;

    @TableField("product_pic")
    private String productPic;

    @TableField("product_name")
    private String productName;

    /** 商标、品牌 */
    @TableField("product_brand")
    private String productBrand;

    /** 商品编号 */
    @TableField("product_sn")
    private String productSn;

    @TableField("product_price")
    private Double productPrice;

    /** 商品购买数量 */
    @TableField("product_quantity")
    private Integer productQuantity;

    /** sku编号 */
    @TableField("product_sku_id")
    private Long productSkuId;

    /** sku条码 */
    @TableField("product_sku_code")
    private String productSkuCode;

    /** 商品分类 ID*/
    @TableField("product_category_id")
    private Long productCategoryId;

    /** 销售属性 */
    private String sp1;
    private String sp2;
    private String sp3;

    /** 促销名称 */
    @TableField("promotion_name")
    private String promotionName;

    /** 促销分解金额 */
    @TableField("promotion_amount")
    private Double promotionAmount;

    /** 优惠券分解金额 */
    @TableField("coupon_amount")
    private Double couponAmount;

    /** 积分分解金额 */
    @TableField("integrationAmount")
    private Double integrationAount;

    /** 商品经过所有优惠的实际金额 */
    @TableField("real_amount")
    private Double realAmount;

    @TableField("gift_integration")
    private Integer giftIntegration;

    @TableField("gift_growth")
    private Integer gifrGrowth;

    @TableField("product_attr")
    private String productAttr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Double getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(Double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Double getIntegrationAount() {
        return integrationAount;
    }

    public void setIntegrationAount(Double integrationAount) {
        this.integrationAount = integrationAount;
    }

    public Double getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Double realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    public Integer getGifrGrowth() {
        return gifrGrowth;
    }

    public void setGifrGrowth(Integer gifrGrowth) {
        this.gifrGrowth = gifrGrowth;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
