package com.mardoner.mall.admin.service.sms;

/**
* @description:  首页专题推荐管理
* @className: HomeRecommendSubjectService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:39
* @version 1.0
*/

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.HomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HomeRecommendSubjectService {

    @Transactional
    int create(List<HomeRecommendSubject> subjectList);

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
    IPage<HomeRecommendSubject> list(String productName, Integer recommendStatus,
                                     Integer current, Integer limit);
}
