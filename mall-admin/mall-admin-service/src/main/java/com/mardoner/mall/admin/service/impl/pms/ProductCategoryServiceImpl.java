package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.entity.pms.ProductCategory;
import com.mardoner.mall.admin.entity.pms.ProductCategoryAttributeRelation;
import com.mardoner.mall.admin.mapper.pms.ProductCategoryAttributeRelationMapper;
import com.mardoner.mall.admin.mapper.pms.ProductCategoryMapper;
import com.mardoner.mall.admin.mapper.pms.ProductMapper;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductCategoryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductCategoryWithChildren;
import com.mardoner.mall.admin.service.pms.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @Description:  商品分类
* @ClassName: ProductCategoryServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 14:01
* @Version 1.0
*/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource(name = "productCategoryMapper")
    private ProductCategoryMapper productCategoryMapper;
    @Resource(name = "productCategoryAttributeRelationMapper")
    private ProductCategoryAttributeRelationMapper relationMapper;
    @Resource(name = "productMapper")
    private ProductMapper productMapper;

    @Override
    public int create(PmsProductCategoryParam param) {
        ProductCategory category = new ProductCategory();
        BeanUtils.copyProperties(param, category);
        category.setProductCount(0);
        // 没有父级分类时划分为一级分类
        setCategoryLevel(category);
        int count = productCategoryMapper.insert(category);

        // 创建筛选属性相关（pms_product_category_attribute_relation）
        if(!CollectionUtils.isEmpty(param.getProductAttributeIdList())){
            insertRelationList(param.getProductAttributeIdList(), category.getId());
        }

        return count;
    }

    private void insertRelationList(List<Long> attributeIds, Long categoryId) {
        List<ProductCategoryAttributeRelation> relationList =
        attributeIds.stream().map(attrId -> {
            ProductCategoryAttributeRelation relation =
                    new ProductCategoryAttributeRelation();
            relation.setProductCategoryId(categoryId);
            relation.setProductAttributeId(attrId);
            return relation;
        }).collect(Collectors.toList());
        relationMapper.insertList(relationList);
    }

    @Override
    public int update(Long id, PmsProductCategoryParam param) {
        // 更新商品分类信息
        ProductCategory category = new ProductCategory();
        category.setId(id);
        BeanUtils.copyProperties(param,category);
        setCategoryLevel(category);
        int count = productCategoryMapper.updateById(category);

        // 更新商品中分类名称
        Product product = new Product();
        product.setProductCategoryName(category.getName());
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        wrapper.eq("product_category_id", category.getId());
        productMapper.update(product, wrapper);

        // 更新与商品属性相关信息
        // 先将原有关联记录全部删除
        QueryWrapper<ProductCategoryAttributeRelation> deleteWrapper =
                new QueryWrapper<>();
        deleteWrapper.eq("product_category_id", id);
        relationMapper.delete(deleteWrapper);

        if(!CollectionUtils.isEmpty(param.getProductAttributeIdList())){
            insertRelationList(param.getProductAttributeIdList(), id);
        }

        return count;
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteById(id);
    }

    @Override
    public ProductCategory getById(Long id) {
        return productCategoryMapper.selectById(id);
    }

    @Override
    public IPage<ProductCategory> list(Long parentId, int current, int limit) {
        IPage<ProductCategory> page = new Page<>(current, limit);
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        if(parentId != null){
            wrapper.eq("parent_id",parentId);
        }
        wrapper.orderByDesc("sort");
        return productCategoryMapper.selectPage(page,wrapper);
    }

    @Override
    public int updateNavStatus(List<Long> ids, int navStatus) {
        UpdateWrapper<ProductCategory> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        ProductCategory category = new ProductCategory();
        category.setNavStatus(navStatus);
        return productCategoryMapper.update(category,wrapper);
    }

    @Override
    public int updateShowStatus(List<Long> ids, int showStatus) {
        UpdateWrapper<ProductCategory> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        ProductCategory category = new ProductCategory();
        category.setShowStatus(showStatus);
        return productCategoryMapper.update(category,wrapper);
    }

    @Override
    public List<PmsProductCategoryWithChildren> listWithChildren() {
        return productCategoryMapper.listWithChildren();
    }

    /**
     * 根据父类id(parentId) 划分level
     * @param category
     */
    private void setCategoryLevel(ProductCategory category) {
        // 没有父级时为一级分类
        if(category.getParentId().equals(0L)){
            category.setLevel(0);
        }else{
            ProductCategory parentCategory =
                    productCategoryMapper.selectById(category.getParentId());
            if(parentCategory != null){
                category.setLevel(parentCategory.getLevel() + 1);
            }else{
                category.setLevel(0);
            }
        }
    }
}
