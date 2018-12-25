package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.pms.Brand;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.mapper.pms.BrandMapper;
import com.mardoner.mall.admin.mapper.pms.ProductMapper;
import com.mardoner.mall.admin.pojo.dto.param.PmsBrandParam;
import com.mardoner.mall.admin.service.pms.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
* @description:  产品品牌管理 实现类
* @class: BrandServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018年12月24日
* @version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Resource(name = "brandMapper")
	private BrandMapper brandMapper;
	@Resource(name = "productMapper")
	private ProductMapper productMapper;
	
	@Override
	public List<Brand> list() {
		return brandMapper.selectList(new QueryWrapper<>());
	}

	@Override
	public Integer createBrand(PmsBrandParam param) {
		Brand brand = getBrand(param);
		return brandMapper.insert(brand);
	}

	@Override
	public Integer updateBrand(Long id, PmsBrandParam param) {
		Brand brand = getBrand(param);
		brand.setId(id);
		
		// 更新品牌同时，更新商品中的品牌名称
		Product product = new Product();
		product.setBrandName(brand.getName());
		productMapper.update(product, new UpdateWrapper<>());
		return brandMapper.updateById(brand);
	}

	private Brand getBrand(PmsBrandParam param) {
		Brand brand = new Brand();
		BeanUtils.copyProperties(param, brand);
		if (StringUtils.isEmpty(brand.getFirstLetter())) {
			brand.setFirstLetter(brand.getName().substring(0, 1));
		}
		return brand;
	}

	@Override
	public Integer delete(Long id) {
		return brandMapper.deleteById(id);
	}

	@Override
	public Integer deleteList(List<Long> ids) {
		return brandMapper.deleteBatchIds(ids);
	}

	@Override
	public Brand getById(Long id) {
		return brandMapper.selectById(id);
	}

	@Override
	public IPage<Brand> listPage(String keyword, int current, int size) {
		IPage<Brand> page = new Page<>(current,size);
		QueryWrapper<Brand> wrapper = new QueryWrapper<>();
		if(!StringUtils.isEmpty(keyword)){
			wrapper.like("name", keyword);
		}
		wrapper.orderByDesc("sort");
		return brandMapper.selectPage(page, wrapper);
	}

	@Override
	public Integer updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
		UpdateWrapper<Brand> wrapper = new UpdateWrapper<>();
		wrapper.in("id", ids);
		Brand brand = new Brand();
		brand.setFactoryStatus(factoryStatus);
		return brandMapper.update(brand, wrapper);
	}

	@Override
	public Integer updateShowStatus(List<Long> ids, Integer showStatus) {
		UpdateWrapper<Brand> wrapper = new UpdateWrapper<>();
		wrapper.in("id", ids);
		Brand brand = new Brand();
		brand.setShowStatus(showStatus);
		return brandMapper.update(brand, wrapper);
	}

}
