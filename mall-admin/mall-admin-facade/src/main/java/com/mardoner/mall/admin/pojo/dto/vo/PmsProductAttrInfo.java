package com.mardoner.mall.admin.pojo.dto.vo;

import java.io.Serializable;

/**
* @Description:  商品分类对应属性信息, 相当于属性分类和属性表的关联表 实体类
* @ClassName: PmsProductAttrInfo
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 11:31
* @Version 1.0
*/
public class PmsProductAttrInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long attributeId;
    private Long attributeCategoryId;

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public void setAttributeCategoryId(Long attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }
}
