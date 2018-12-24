package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductCategory;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductCategoryWithChildren;

import java.util.List;

/**
* @Description:   产品分类 mapper
* @ClassName: ProductCategoryMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 16:55
* @Version 1.0
*/
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    /**
     * 返回分类及子分类信息    商品分类只有俩级，不用递归，通过数据库关联自身查询即可
     * @return 分类两级信息
     */
    List<PmsProductCategoryWithChildren> listWithChildren();
}
