package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.Coupon;
import com.mardoner.mall.admin.entity.sms.CouponProductCategoryRelation;
import com.mardoner.mall.admin.entity.sms.CouponProductRelation;
import com.mardoner.mall.admin.enums.CouponEnums;
import com.mardoner.mall.admin.mapper.sms.CouponMapper;
import com.mardoner.mall.admin.mapper.sms.CouponProductCategoryRelationMapper;
import com.mardoner.mall.admin.mapper.sms.CouponProductRelationMapper;
import com.mardoner.mall.admin.pojo.dto.param.SmsCouponParam;
import com.mardoner.mall.admin.service.sms.CouponService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
* @description:  优惠券管理实现
* @className: CouponServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:44
* @version 1.0
*/
@Service
public class CouponServiceImpl implements CouponService {
    @Resource(name = "couponMapper")
    private CouponMapper couponMapper;
    @Resource(name = "couponProductRelationMapper")
    private CouponProductRelationMapper productRelationMapper;
    @Resource(name = "couponProductCategoryRelationMapper")
    private CouponProductCategoryRelationMapper productCategoryRelationMapper;


    @Override
    public int create(SmsCouponParam param) {
        param.setCount(param.getPublishCount());
        param.setUseCount(0);
        param.setReceiveCount(0);
        int count = couponMapper.insert(param);

        // 插入优惠券表和商品关系
        if(param.getUseType().equals(CouponEnums.PRODUCT_USE.getCode())){
            // 该优惠券只能使用给特定商品
            param.getProductRelationList().forEach(productRelation -> {
                productRelation.setCouponId(param.getId());
            });
            productRelationMapper.insertList(param.getProductRelationList());
        }
        if(param.getUseType().equals(CouponEnums.CATEGORY_USE.getCode())){
            // 指定商品分类使用
            param.getProductCategoryRelationList().forEach(category -> {
                category.setCouponId(param.getId());
            });
            productCategoryRelationMapper.insertList(param.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public int update(Long id, SmsCouponParam param) {
        // 删除优惠券
        param.setId(id);
        int count = couponMapper.deleteById(param);

        // 删除后插入优惠券和商品、商品关联表
        if(param.getUseType().equals(CouponEnums.CATEGORY_USE.getCode())){
            // 与商品分类关联
            deleteProductCategoryRelation(id);
            productCategoryRelationMapper.insertList(param.getProductCategoryRelationList());
        }else if(param.getUseType().equals(CouponEnums.PRODUCT_USE.getCode())){
            // 与商品关联
            deleteProductRelation(id);
            productRelationMapper.insertList(param.getProductRelationList());
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        // 删除优惠券
        int count = couponMapper.deleteById(id);

        // 删除商品关联
        deleteProductRelation(id);

        // 删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    private void deleteProductCategoryRelation(Long couponId) {
        QueryWrapper<CouponProductCategoryRelation> deleteWrapper2 =
                new QueryWrapper<>();
        deleteWrapper2.eq("coupon_id",couponId);
        productCategoryRelationMapper.delete(deleteWrapper2);
    }

    private void deleteProductRelation(Long couponId) {
        QueryWrapper<CouponProductRelation> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("coupon_id",couponId);
        productRelationMapper.delete(deleteWrapper);
    }

    @Override
    public IPage<Coupon> list(String name, Integer type, Integer current, Integer limit) {
        // 查询实体
        Coupon queryEntity = new Coupon();
        queryEntity.setType(type);
        // 模糊查询条件构造
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>(queryEntity);
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        IPage<Coupon> page = new Page<>(current,limit);
        return couponMapper.selectPage(page,wrapper);
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return couponMapper.getItem(id);
    }
}
