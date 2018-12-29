package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.HomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @description:  首页人气商品推荐
* @className: HomeRecommendProductService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:35
* @version 1.0
*/
public interface HomeRecommendProductService {

    @Transactional
    int create(List<HomeRecommendProduct> productList);

    int deleteBatch(List<Long> ids);

    int updateSort(Long id, Integer sort);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询
     * @param productName 产品名称模糊查询
     * @param recommendStatus 推荐状态
     * @param current
     * @param limit
     * @return
     */
    IPage<HomeRecommendProduct> list(String productName, Integer recommendStatus,
                                     Integer current, Integer limit);
}
