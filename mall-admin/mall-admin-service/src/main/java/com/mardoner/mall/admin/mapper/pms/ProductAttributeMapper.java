package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductAttribute;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description:  商品属性 mapper
* @ClassName: ProductAttributeMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 12:38
* @Version 1.0
*/
public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {

    /**
     * 查询商品分类下 属性和属性分类id关联
     * @param productCategoryId 分类
     * @return 两者关联id
     */
    List<PmsProductAttrInfo> getAttrInfo(@Param("categoryId")Long productCategoryId);
}
