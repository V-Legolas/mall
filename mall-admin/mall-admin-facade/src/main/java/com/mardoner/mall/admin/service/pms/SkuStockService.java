package com.mardoner.mall.admin.service.pms;


import java.util.List;

import com.mardoner.mall.admin.entity.pms.SkuStock;

/**
 * 
* @description:  商品库存管理 serivce
* @class: PmsSkuStockService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018年12月23日
* @version 1.0
 */
public interface SkuStockService {
	
	/**
	 * 根据产品id或者sku_code进行模糊查询
	* @param keywords
	* @return 商品库存集合
	 */
	List<SkuStock> list(String keywords);
	
	/**
	 * 批量更新商品库存信息
	* @param pid 商品id
	* @param skuStockList 库存信息集合
	* @return 操作影响记录数
	 */
	Integer update(Long pid, List<SkuStock> skuStockList);
}
