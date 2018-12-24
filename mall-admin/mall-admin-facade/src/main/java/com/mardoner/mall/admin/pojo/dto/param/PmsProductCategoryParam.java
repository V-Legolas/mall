package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
* @Description:  创建商品分类入参
* @ClassName: PmsProductCategoryParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 11:39
* @Version 1.0
*/
@ApiModel("创建商品分类入参")
public class PmsProductCategoryParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父级分类")
    private Long parentId;

    @ApiModelProperty(value = "分类名称",required = true)
    @NotBlank(message = "商品分类名称不能为空")
    private String name;

    @ApiModelProperty(value = "分类单位")
    private String productUnit;

    @ApiModelProperty("是否在导航栏显示：0->不显示、1->显示")
    private Integer navStatus;

    @ApiModelProperty("显示状态：0->不显示、1->显示")
    private Integer showStatus;

    @ApiModelProperty("排序字段")
    @Min(value = 0,message = "排序最小为0")
    private Integer sort;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("分类描述")
    private String description;

    @ApiModelProperty("产品相关属性集合筛选")
    private List<Long> productAttributeIdList;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getProductAttributeIdList() {
        return productAttributeIdList;
    }

    public void setProductAttributeIdList(List<Long> productAttributeIdList) {
        this.productAttributeIdList = productAttributeIdList;
    }
}
