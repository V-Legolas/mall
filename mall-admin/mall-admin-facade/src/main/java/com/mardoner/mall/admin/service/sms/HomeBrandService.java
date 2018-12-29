package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.HomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @description:  首页品牌管理
* @className: HomeBrandService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:23
* @version 1.0
*/
public interface HomeBrandService {
	
    int create(List<HomeBrand> brandList);

    /**
     * 修改品牌推荐排序
     */
    int updateSort(Long id, Integer sort);

    /**
     * 更新推荐状态
     * @param ids 品牌id集合
     * @param recommendStatus 推荐状态
     * @return 影响记录数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量删除
     */
    int deleteBatch(List<Long> ids);

    /**
     * 分页查询推荐
     */
    IPage<HomeBrand> list(String brandName, Integer recommendStatus,
                          Integer current, Integer limit);
}
