package com.mardoner.mall.admin.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description:  商品属性分类实体类
* @ClassName: ProductAttributeCategory
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:36
* @Version 1.0
*/
@TableName("pms_product_attribute_category")
public class ProductAttributeCategory extends Model<ProductAttributeCategory> {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    @TableField("attribute_count")
    private Integer attributeCount;

    @TableField("param_count")
    private Integer paramCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
