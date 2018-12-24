package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @Description:  分页查询商品条件
* @ClassName: PmsProductQueryParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 17:29
* @Version 1.0
*/
@ApiModel("分页查询商品条件")
public class PmsProductQueryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("上架状态")
    private Integer publishStatus;

    @ApiModelProperty("审核状态")
    private Integer virifyStatus;

    @ApiModelProperty("商品名称模糊查询关键字")
    private String keyword;

    @ApiModelProperty("商品货号")
    private String productSn;

    @ApiModelProperty("商品分类编号")
    private Long productCategoryId;

    @ApiModelProperty("商品品牌编号")
    private Long brandId;

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getVirifyStatus() {
        return virifyStatus;
    }

    public void setVirifyStatus(Integer virifyStatus) {
        this.virifyStatus = virifyStatus;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
