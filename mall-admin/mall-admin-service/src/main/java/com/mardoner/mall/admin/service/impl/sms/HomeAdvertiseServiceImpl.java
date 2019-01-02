package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.HomeAdvertise;
import com.mardoner.mall.admin.mapper.sms.HomeAdvertiseMapper;
import com.mardoner.mall.admin.service.sms.HomeAdvertiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 
* @description:  主页产品推荐
* @class: HomeAdvertiseServiceImpl
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018年12月29日
* @version 1.0
 */
@Service
public class HomeAdvertiseServiceImpl implements HomeAdvertiseService {

	@Resource(name = "homeAdvertiseMapper")
	private HomeAdvertiseMapper advertiseMapper;
	
	@Override
	public int create(HomeAdvertise advertise) {
		advertise.setClickCount(0);
		advertise.setOrderCount(0);
		return advertiseMapper.insert(advertise);
	}

	@Override
	public int delete(List<Long> ids) {
		return advertiseMapper.deleteBatchIds(ids);
	}

	@Override
	public int updateStatus(Long id, Integer status) {
		HomeAdvertise advertise = new HomeAdvertise();
		advertise.setId(id);
		advertise.setStatus(status);
		return advertiseMapper.updateById(advertise);
	}

	@Override
	public int update(Long id, HomeAdvertise ad) {
		ad.setId(id);
		return advertiseMapper.updateById(ad);
	}

	@Override
	public HomeAdvertise getById(Long id) {
		return advertiseMapper.selectById(id);
	}

	@Override
	public IPage<HomeAdvertise> list(String name, Integer type, String endDate, 
			Integer current, Integer limit) {
		IPage<HomeAdvertise> page = new Page<>(current,limit);
		
		HomeAdvertise queryEntity = new HomeAdvertise();
		queryEntity.setType(type);
		QueryWrapper<HomeAdvertise> wrapper = new QueryWrapper<>();
		if(!StringUtils.isEmpty(name)) {
			wrapper.like("name", name);
		}
		if(!StringUtils.isEmpty(endDate)) {
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime startTime = LocalDateTime.parse(endDate + " 00:00:00",timeFormat);
			LocalDateTime endTime = LocalDateTime.parse(endDate + " 23:59:59",timeFormat);
			wrapper.between("end_time", startTime, endTime);
		}
		return advertiseMapper.selectPage(page,wrapper);
	}

	
}
