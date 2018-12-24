package com.mardoner.mall.admin.pojo.dto.param;

import com.mardoner.mall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
* @Description:  创建商品参数入参
* @ClassName: PmsProductAttributeParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 11:10
* @Version 1.0
*/
@ApiModel("创建商品属性入参")
public class PmsProductAttributeParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性分类id", required = true)
    @NotEmpty(message = "属性分类不能为空")
    private Long productAttributeCategoryId;

    @ApiModelProperty(value = "属性名称" ,required = true)
    @NotBlank(message = "属性名称不能为空")
    private String name;

    @ApiModelProperty(value = "属性选择类型(0->唯一；1->单选；2-> 多选)")
    @FlagValidator(value = {"0","1","2"})
    private Integer selectType;

    @ApiModelProperty(value = "输入类型(0->手工输入/1->列表选取)")
    @FlagValidator({"0","1"})
    private Integer inputType;

    @ApiModelProperty("可选列表,','分割")
    private String inputList;

    @ApiModelProperty("排序字段")
    private Integer sort;

    @ApiModelProperty("分类删选类型：0->普通、1->颜色")
    @FlagValidator({"0","1"})
    private Integer filterType;

    @ApiModelProperty("检索类型：0->不检索、1->关键字检索、2->范围检索")
    @FlagValidator({"0","1","2"})
    private Integer searchType;

    @ApiModelProperty("相同属性产品是否关联：0->不关联、1->关联")
    @FlagValidator({"0","1"})
    private Integer relatedStatus;

    @ApiModelProperty("是否支持手动添加：0->不支持、1->支持")
    @FlagValidator({"0","1"})
    private Integer handAddStatus;

    @ApiModelProperty("属性类型：0->规格、1->参数")
    @FlagValidator({"0","1"})
    private Integer type;

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
