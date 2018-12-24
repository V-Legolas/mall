package com.mardoner.mall.admin.pojo.dto.vo;

import com.mardoner.mall.admin.pojo.dto.param.PmsProductParam;

/**
* @Description:  商品详细信息
* @ClassName: PmsProductResult
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 17:27
* @Version 1.0
*/
public class PmsProductResult extends PmsProductParam {
    /** 商品所选分类父类id */
    private Long categoryParentId;

    public Long getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Long categoryParentId) {
        this.categoryParentId = categoryParentId;
    }
}
