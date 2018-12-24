package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;
import com.mardoner.mall.admin.mapper.pms.ProductAttributeCategoryMapper;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttributeCategoryItem;
import com.mardoner.mall.admin.service.pms.ProductAttributeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  产品属性分类 服务实现
* @ClassName: ProductAttributeCategoryServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 12:14
* @Version 1.0
*/
@Service
public class ProductAttributeCategoryServiceImpl implements ProductAttributeCategoryService {

    @Resource(name = "productAttributeCategoryMapper")
    private ProductAttributeCategoryMapper attributeCategoryMapper;

    @Override
    public Integer create(String name) {
        ProductAttributeCategory attributeCategory =
                new ProductAttributeCategory();
        attributeCategory.setName(name);
        return attributeCategoryMapper.insert(attributeCategory);
    }

    @Override
    public Integer update(Long id, String name) {
        ProductAttributeCategory attributeCategory =
                new ProductAttributeCategory();
        attributeCategory.setName(name);
        attributeCategory.setId(id);
        return attributeCategoryMapper.updateById(attributeCategory);
    }

    @Override
    public Integer delete(Long id) {
        return attributeCategoryMapper.deleteById(id);
    }

    @Override
    public ProductAttributeCategory get(Long id) {
        return attributeCategoryMapper.selectById(id);
    }

    @Override
    public IPage<ProductAttributeCategory> listPage(Integer current, Integer limit) {
        IPage<ProductAttributeCategory> page =
                new Page<>(current,limit);
        return attributeCategoryMapper.selectPage(page,new QueryWrapper<>());
    }

    @Override
    public List<PmsProductAttributeCategoryItem> listWithAttr() {
        return attributeCategoryMapper.listWithAttr();
    }
}
