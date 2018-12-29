package com.mardoner.mall.admin.mapper.sms;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.HomeBrand;

/**
* @description: 首页推荐品牌表 mapper接口
* @className: HomeBrandMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface HomeBrandMapper extends BaseMapper<HomeBrand> {
	
	int insertList(@Param("list") List<HomeBrand> brandList);
}
