package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * 
* @description:  商品操作 mapper接口
* @class: ProductMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018年12月24日
* @version 1.0
 */
public interface ProductMapper extends BaseMapper<Product> {

    PmsProductResult detailInfo(@Param("id")Long productId);
}
