package com.mardoner.mall.admin.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description:  商品属性参数表
* @ClassName: ProductAttributeService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:46
* @Version 1.0
*/
@TableName("pms_product_attribute")
public class ProductAttribute extends Model<ProductAttribute> {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("product_attribute_category_id")
    private Long productAttributeCategoryId;

    /** 属性选择类型 0->唯一、1->单选、2->多选 */
    @TableField("select_type")
    private Integer selectType;

    private String name;

    /** 属性录入方式 0->手工输入/1->从列表玄虚 */
    @TableField("input_type")
    private Integer inputType;

    /** 可选值列表，以','分割 */
    @TableField("input_list")
    private String inputList;

    private Integer sort;

    /** 分类删选样式 1->普通 2->颜色 */
    @TableField("filter_type")
    private Integer filterType;

    /** 检索类型 0->无需检索，1->关键字检索 ，2->范围检索 */
    @TableField("search_type")
    private Integer searchType;

    /** 相同属性产品是否关联 0->不关联 1->关联 */
    @TableField("related_status")
    private Integer relatedStatus;

    /** 是否支持手动新增 0->不支持 1->支持*/
    @TableField("hand_add_status")
    private Integer handAddStatus;

    /** 属性类型 0->规格 1->参数 */
    @TableField("type")
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
