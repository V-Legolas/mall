package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  商品属性值
* @className: ProductAttributeValueMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 20:26
* @version 1.0
*/
public interface ProductAttributeValueMapper extends BaseMapper<ProductAttributeValue> {

    int insertList(@Param("list") List<ProductAttributeValue> dataList);
}
