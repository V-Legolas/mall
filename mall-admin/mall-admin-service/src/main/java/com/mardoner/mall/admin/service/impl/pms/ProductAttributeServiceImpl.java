package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.pms.ProductAttribute;
import com.mardoner.mall.admin.entity.pms.ProductAttributeCategory;
import com.mardoner.mall.admin.enums.ProductEnums;
import com.mardoner.mall.admin.mapper.pms.ProductAttributeCategoryMapper;
import com.mardoner.mall.admin.mapper.pms.ProductAttributeMapper;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductAttributeParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttrInfo;
import com.mardoner.mall.admin.service.pms.ProductAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  商品 属性 业务逻辑实现
* @ClassName: ProductAttributeServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 12:51
* @Version 1.0
*/
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    @Resource(name = "productAttributeMapper")
    private ProductAttributeMapper attributeMapper;
    @Resource(name = "productAttributeCategoryMapper")
    private ProductAttributeCategoryMapper categoryMapper;

    @Override
    public IPage<ProductAttribute> listPage(Long cid, Integer type, Integer current, Integer limit) {
        ProductAttribute attribute = new ProductAttribute();
        attribute.setProductAttributeCategoryId(cid);
        attribute.setType(type);
        QueryWrapper<ProductAttribute> wrapper =
                new QueryWrapper<>(attribute);
        wrapper.orderByDesc("sort");
        IPage<ProductAttribute> page = new Page<>(current,limit);
        return attributeMapper.selectPage(page,wrapper);
    }

    @Override
    public Integer create(PmsProductAttributeParam param) {
        ProductAttribute attr = new ProductAttribute();
        BeanUtils.copyProperties(param, attr);
        int count = attributeMapper.insert(attr);

        // 更新商品属性分类数量
        ProductAttributeCategory category =
                categoryMapper.selectById(attr.getProductAttributeCategoryId());
        if(attr.getType().equals(ProductEnums.ATTR_TYPE.getCode())){
            // 属于规格类型
            category.setAttributeCount(category.getAttributeCount() + 1);
        }else if(attr.getType().equals(ProductEnums.PARAM_TYPE.getCode())){
            // 属于参数类型
            category.setParamCount(category.getParamCount() + 1);
        }
        categoryMapper.updateById(category);

        return count;
    }

    @Override
    public Integer update(Long id, PmsProductAttributeParam param) {
        // 未更新之前数据
        ProductAttribute oldAttr = attributeMapper.selectById(id);

        ProductAttribute attribute = new ProductAttribute();
        attribute.setId(id);
        BeanUtils.copyProperties(param, attribute);
        int count = attributeMapper.updateById(attribute);

        // 类型是否发生变化，如果发生变化，分类相应count也应变化
        if(!attribute.getType().equals(oldAttr.getType())){
            ProductAttributeCategory category =
                    categoryMapper.selectById(attribute.getProductAttributeCategoryId());
            if(attribute.getType().equals(ProductEnums.ATTR_TYPE.getCode())){
                // 由参数类型转变为规格类型
                category.setAttributeCount(category.getAttributeCount() + 1);
                category.setParamCount(category.getParamCount() - 1);
            }else if(attribute.getType().equals(ProductEnums.PARAM_TYPE.getCode())){
                // 由规格类型变为参数类型
                category.setParamCount(category.getParamCount() + 1);
                category.setAttributeCount(category.getAttributeCount() - 1);
            }
            categoryMapper.updateById(category);
        }
        return count;
    }

    @Override
    public ProductAttribute getById(Long id) {
        return attributeMapper.selectById(id);
    }

    @Override
    public Integer delete(List<Long> ids) {
       // 获取分类，方便修改数量
        ProductAttribute attribute =
                attributeMapper.selectById(ids.get(0));
        ProductAttributeCategory category =
                categoryMapper.selectById(attribute.getProductAttributeCategoryId());
        int count = attributeMapper.deleteBatchIds(ids);

        // 修改分类下数量
        if(attribute.getType().equals(ProductEnums.ATTR_TYPE.getCode())){
            // 规格类型
            category.setAttributeCount(category.getAttributeCount() - count);
        }else if(attribute.getType().equals(ProductEnums.PARAM_TYPE.getCode())){
            // 参数类型
            category.setParamCount(category.getParamCount() - count);
        }
        categoryMapper.updateById(category);

        return count;
    }

    @Override
    public List<PmsProductAttrInfo> getAttrInfo(Long productCategoryId) {
        return attributeMapper.getAttrInfo(productCategoryId);
    }
}
