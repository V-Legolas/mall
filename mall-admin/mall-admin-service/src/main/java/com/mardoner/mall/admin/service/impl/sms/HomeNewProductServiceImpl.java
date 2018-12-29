package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.HomeNewProduct;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.mapper.sms.HomeNewProductMapper;
import com.mardoner.mall.admin.service.sms.HomeNewProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  主页新品推荐
* @className: HomeNewProductServiceImpl
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018/12/29 18:24
* @version 1.0
*/
@Service
public class HomeNewProductServiceImpl implements HomeNewProductService {

    @Resource(name = "homeNewProductMapper")
    private HomeNewProductMapper newProductMapper;

    @Override
    public int create(List<HomeNewProduct> newProductList) {
        newProductList.forEach(newProduct -> {
            newProduct.setRecommendStatus(OrderEnums.USE.getCode());
            newProduct.setSort(0);
        });
        return newProductMapper.insertList(newProductList);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return newProductMapper.deleteBatchIds(ids);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        HomeNewProduct product = new HomeNewProduct();
        product.setId(id);
        product.setSort(sort);
        return newProductMapper.updateById(product);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeNewProduct setEntity = new HomeNewProduct();
        setEntity.setRecommendStatus(recommendStatus);
        UpdateWrapper<HomeNewProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        return newProductMapper.update(setEntity, wrapper);
    }

    @Override
    public IPage<HomeNewProduct> list(String productName, Integer recommendStatus,
                                      Integer current, Integer limit) {
        // 分页对象
        IPage<HomeNewProduct> page = new Page<>(current,limit);
        HomeNewProduct queryEntity = new HomeNewProduct();
        queryEntity.setRecommendStatus(recommendStatus);
        QueryWrapper<HomeNewProduct> wrapper = new QueryWrapper<>(queryEntity);
        if(!StringUtils.isEmpty(productName)){
            wrapper.like("product_name",productName);
        }
        wrapper.orderByDesc("sort");
        return newProductMapper.selectPage(page, wrapper);
    }
}
