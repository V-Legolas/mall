package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.HomeRecommendProduct;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.mapper.sms.HomeRecommendProductMapper;
import com.mardoner.mall.admin.service.sms.HomeRecommendProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  主页产品推荐
* @className: HomeRecommendProductServiceImpl
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018/12/29 19:00 
* @version 1.0
*/
@Service
public class HomeRecommendProductServiceImpl implements HomeRecommendProductService {

    @Resource(name = "homeRecommendProductMapper")
    private HomeRecommendProductMapper recommendProductMapper;

    @Override
    public int create(List<HomeRecommendProduct> productList) {
        productList.forEach(recommend -> {
            recommend.setRecommendStatus(OrderEnums.USE.getCode());
            recommend.setSort(0);
        });
        return recommendProductMapper.insertList(productList);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return recommendProductMapper.deleteBatchIds(ids);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        HomeRecommendProduct updateEntity = new HomeRecommendProduct();
        updateEntity.setId(id);
        updateEntity.setSort(sort);
        return recommendProductMapper.updateById(updateEntity);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeRecommendProduct setEntity = new HomeRecommendProduct();
        setEntity.setRecommendStatus(recommendStatus);

        UpdateWrapper<HomeRecommendProduct> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id",ids);
        return recommendProductMapper.update(setEntity, updateWrapper);
    }

    @Override
    public IPage<HomeRecommendProduct> list(String productName, Integer recommendStatus,
                                            Integer current, Integer limit) {
        IPage<HomeRecommendProduct> page = new Page<>(current, limit);
        HomeRecommendProduct queryEntity = new HomeRecommendProduct();
        queryEntity.setRecommendStatus(recommendStatus);
        QueryWrapper<HomeRecommendProduct> wrapper = new QueryWrapper<>();
        wrapper.setEntity(queryEntity);
        if(!StringUtils.isEmpty(productName)){
            wrapper.like("product_name", productName);
        }
        wrapper.orderByDesc("sort");
        return recommendProductMapper.selectPage(page, wrapper);
    }
}
