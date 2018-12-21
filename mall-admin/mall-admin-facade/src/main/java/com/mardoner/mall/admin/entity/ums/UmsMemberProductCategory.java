package com.mardoner.mall.admin.entity.ums;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 会员产品分类关系表（用户喜欢的分类）
* @ClassName: UmsMemberProductCategory
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 17:39
* @Version 1.0
*/
@TableName("ums_member_product_category")
public class UmsMemberProductCategory extends Model<UmsMemberProductCategory> {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("product_category_id")
    private Long productCategoryId;

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

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
