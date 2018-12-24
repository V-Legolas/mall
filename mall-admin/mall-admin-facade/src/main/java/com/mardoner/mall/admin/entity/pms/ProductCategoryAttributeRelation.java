package com.mardoner.mall.admin.entity.pms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description:  商品分类与属性 联系实体类
* @ClassName: ProductCategoryAttributeRelation
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 17:08
* @Version 1.0
*/
@TableName("pms_product_category_attribute_relation")
public class ProductCategoryAttributeRelation extends Model<ProductCategoryAttributeRelation> {
    @TableId(type= IdType.AUTO)
    private Long id;

    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("product_attribute_id")
    private Long productAttributeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
