package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.HomeBrand;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.mapper.sms.HomeBrandMapper;
import com.mardoner.mall.admin.service.sms.HomeBrandService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
* @description:  
* @class: HomeBrandServiceImpl
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018年12月29日
* @version 1.0
 */
@Service
public class HomeBrandServiceImpl implements HomeBrandService {

	@Resource(name = "homeBrandMapper")
	private HomeBrandMapper brandMapper;
	
	@Override
	public int create(List<HomeBrand> brandList) {
		brandList.forEach(brand -> {
			brand.setSort(0);
			brand.setRecommendStatus(OrderEnums.USE.getCode());
		});
		return brandMapper.insertList(brandList);
	}

	@Override
	public int updateSort(Long id, Integer sort) {
		HomeBrand brand = new HomeBrand();
		brand.setSort(sort);
		brand.setId(id);
		return brandMapper.updateById(brand);
	}

	@Override
	public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
		HomeBrand setEntity = new HomeBrand();
		setEntity.setRecommendStatus(recommendStatus);
		UpdateWrapper<HomeBrand> wrapper = new UpdateWrapper<>();
		wrapper.in("id",ids);
		return brandMapper.update(setEntity,wrapper);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return brandMapper.deleteBatchIds(ids);
	}

	@Override
	public IPage<HomeBrand> list(String brandName, Integer recommendStatus,
								 Integer current, Integer limit) {
		IPage<HomeBrand> page = new Page<>(current,limit);
		HomeBrand queryEntity = new HomeBrand();
		queryEntity.setRecommendStatus(recommendStatus);
		QueryWrapper<HomeBrand> wrapper = new QueryWrapper<>(queryEntity);
		if(!StringUtils.isEmpty(brandName)){
			wrapper.like("name",brandName);
		}
		wrapper.orderByDesc("sort");
		return brandMapper.selectPage(page, wrapper);
	}
	
}
