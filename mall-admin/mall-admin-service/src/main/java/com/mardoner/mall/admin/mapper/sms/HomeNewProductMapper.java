package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.sms.HomeNewProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 新鲜好物表 mapper接口
* @className: HomeNewProductMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface HomeNewProductMapper extends BaseMapper<HomeNewProduct> {

    /**
     * 批量插入主页新品
     * @param productList
     * @return
     */
    int insertList(@Param("list")List<HomeNewProduct> productList);

}
