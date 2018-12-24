package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  满减
* @className: ProductFullReductionMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 20:20
* @version 1.0
*/
public interface ProductFullReductionMapper extends BaseMapper<ProductFullReduction> {

    int insertList(@Param("list")List<ProductFullReduction> dataList);
}
