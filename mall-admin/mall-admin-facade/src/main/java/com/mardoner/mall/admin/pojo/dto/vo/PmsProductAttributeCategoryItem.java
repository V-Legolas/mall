package com.mardoner.mall.admin.pojo.dto.vo;

import com.mardoner.mall.admin.entity.pms.ProductAttribute;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;

import java.util.List;

/**
* @Description:  包含分类属性的 DTO
* @ClassName: PmsProductAttributeCategoryItem
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:58
* @Version 1.0
*/
public class PmsProductAttributeCategoryItem extends ProductAttributeCategory {

    List<ProductAttribute> attributeList;

    public List<ProductAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<ProductAttribute> attributeList) {
        this.attributeList = attributeList;
    }
}
