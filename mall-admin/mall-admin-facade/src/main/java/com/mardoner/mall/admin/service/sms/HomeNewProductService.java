package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.HomeNewProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @description:  首页新品管理
* @className: HomeNewProductService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:29
* @version 1.0
*/
public interface HomeNewProductService {

    @Transactional
    int create(List<HomeNewProduct> newProductList);

    int deleteBatch(List<Long> ids);

    int updateSort(Long id, Integer sort);

    /**
     * 更新推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询推荐
     */
    IPage<HomeNewProduct> list(String productName, Integer recommendStatus,
                               Integer current,Integer limit);
}
