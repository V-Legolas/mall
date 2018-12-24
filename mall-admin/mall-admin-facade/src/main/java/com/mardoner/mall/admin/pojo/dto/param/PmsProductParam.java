package com.mardoner.mall.admin.pojo.dto.param;

import java.util.List;

import com.mardoner.mall.admin.entity.cms.CmsPreferenceAreaProductRelation;
import com.mardoner.mall.admin.entity.cms.CmsSubjectProductRelation;
import com.mardoner.mall.admin.entity.pms.MemberPrice;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.entity.pms.ProductAttributeValue;
import com.mardoner.mall.admin.entity.pms.ProductFullReduction;
import com.mardoner.mall.admin.entity.pms.ProductLadder;
import com.mardoner.mall.admin.entity.pms.SkuStock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @Description:  创建商品 入参
* @ClassName: PmsProductParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 14:00
* @Version 1.0
*/
@ApiModel("创建商品、修改商品入参")
public class PmsProductParam extends Product {

    @ApiModelProperty("商品阶梯价设置")
    private List<ProductLadder> productLadderList;

    @ApiModelProperty("商品满减价格设置")
    private List<ProductFullReduction> fullReductionList;

    @ApiModelProperty("商品会员价格设定")
    private List<MemberPrice> memberPriceList;

    @ApiModelProperty("商品的sku库存信息")
    private List<SkuStock> skuStockList;

    @ApiModelProperty("商品自定义参数及规格信息")
    private List<ProductAttributeValue> attributeValueList;

    @ApiModelProperty("商品专题和商品关系")
    private List<CmsSubjectProductRelation> subjectProductRelationList;

    @ApiModelProperty("优选专区和商品关系")
    private List<CmsPreferenceAreaProductRelation> preferenceAreaProductRelationList;

    public List<ProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<ProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<ProductFullReduction> getFullReductionList() {
        return fullReductionList;
    }

    public void setFullReductionList(List<ProductFullReduction> fullReductionList) {
        this.fullReductionList = fullReductionList;
    }

    public List<MemberPrice> getMemberPriceList() {
        return memberPriceList;
    }

    public void setMemberPriceList(List<MemberPrice> memberPriceList) {
        this.memberPriceList = memberPriceList;
    }

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<ProductAttributeValue> getAttributeValueList() {
        return attributeValueList;
    }

    public void setAttributeValueList(List<ProductAttributeValue> attributeValueList) {
        this.attributeValueList = attributeValueList;
    }

    public List<CmsSubjectProductRelation> getSubjectProductRelationList() {
        return subjectProductRelationList;
    }

    public void setSubjectProductRelationList(List<CmsSubjectProductRelation> subjectProductRelationList) {
        this.subjectProductRelationList = subjectProductRelationList;
    }

    public List<CmsPreferenceAreaProductRelation> getPreferenceAreaProductRelationList() {
        return preferenceAreaProductRelationList;
    }

    public void setPreferenceAreaProductRelationList(List<CmsPreferenceAreaProductRelation> preferenceAreaProductRelationList) {
        this.preferenceAreaProductRelationList = preferenceAreaProductRelationList;
    }
}
