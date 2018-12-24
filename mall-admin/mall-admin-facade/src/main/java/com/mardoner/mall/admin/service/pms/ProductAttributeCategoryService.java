package com.mardoner.mall.admin.service.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttributeCategoryItem;

import java.util.List;

/**
* @Description:  商品属性分类 service
* @ClassName: ProductAttributeCategoryService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:32
* @Version 1.0
*/
public interface ProductAttributeCategoryService {

    /**
     * 创建分类
     * @param name 名称
     * @return 操作影响记录数
     */
    Integer create(String name);

    /**
     * 更新
     * @param id 属性分类id
     * @param name 新的名称
     * @return 操作影响记录
     */
    Integer update(Long id, String name);

    Integer delete(Long id);

    ProductAttributeCategory get(Long id);

    IPage<ProductAttributeCategory> listPage(Integer current, Integer limit);

    /**
     * 获取更加详细的参数信息
     * @return 具体参数信息
     */
    List<PmsProductAttributeCategoryItem> listWithAttr();
}
