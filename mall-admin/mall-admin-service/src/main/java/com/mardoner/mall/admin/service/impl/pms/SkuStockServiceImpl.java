package com.mardoner.mall.admin.service.impl.pms;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mardoner.mall.admin.entity.pms.SkuStock;
import com.mardoner.mall.admin.mapper.pms.SkuStockMapper;
import com.mardoner.mall.admin.service.pms.SkuStockService;

/**
 * 
* @description:  sku 库存管理实现
* @class: SkuStockServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018年12月24日
* @version 1.0
 */
@Service
public class SkuStockServiceImpl implements SkuStockService{

	@Resource(name = "skuStockMapper")
	private SkuStockMapper stockMapper;
	
	@Override
	public List<SkuStock> list(String keywords) {
		QueryWrapper<SkuStock> wrapper = new QueryWrapper<>();
		wrapper.like("sku_code", keywords);
		return stockMapper.selectList(wrapper);
	}

	@Override
	public Integer update(Long pid, List<SkuStock> skuStockList) {
		return stockMapper.replaceList(skuStockList);
	}
	
}
