package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description:  产品分类与产品属性关联表 mapper
* @ClassName: ProductCategoryAttributeRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 17:17
* @Version 1.0
*/
public interface ProductCategoryAttributeRelationMapper
        extends BaseMapper<ProductCategoryAttributeRelation> {

    /**
     * 批量插入关联记录
     * @param relationList 产品分类与产品属性关联记录集合
     * @return 操作影响记录数
     */
    Integer insertList(@Param("relationList") List<ProductCategoryAttributeRelation> relationList);
}
