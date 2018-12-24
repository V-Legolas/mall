package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.SkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
* @description:  sku 库存管理 mapper
* @class: SkuStockMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018年12月24日
* @version 1.0
 */
public interface SkuStockMapper extends BaseMapper<SkuStock> {
	
	/**
	 * 批量替换库存信息（根据唯一主键id替换），没有则插入
	* @param stockList 库存信息集合
	* @return 操作影响记录数
	 */
	int replaceList(@Param("stockList")List<SkuStock> stockList);

	int insertList(@Param("list")List<SkuStock> dataList);
}
