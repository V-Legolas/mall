package com.mardoner.mall.admin.pojo.dto.vo;

import com.mardoner.mall.admin.entity.pms.ProductCategory;

import java.util.List;

/**
* @Description:  层级结构的产品分类
* @ClassName: PmsProductCategoryWithChildren
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 13:56
* @Version 1.0
*/
public class PmsProductCategoryWithChildren extends ProductCategory {

    private List<ProductCategory> children;

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }
}
