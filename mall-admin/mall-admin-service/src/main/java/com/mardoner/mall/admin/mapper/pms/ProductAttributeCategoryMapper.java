package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttributeCategoryItem;

import java.util.List;

/**
* @Description:  商品属性分类 mapper
* @ClassName: ProductAttributeCategoryMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 12:18
* @Version 1.0
*/
public interface ProductAttributeCategoryMapper extends BaseMapper<ProductAttributeCategory> {

    List<PmsProductAttributeCategoryItem> listWithAttr();
}
