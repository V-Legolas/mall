package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.HomeAdvertise;

import java.util.List;

/**
* @description:  首页广告管理
* @className: HomeAdvertiseService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 20:17
* @version 1.0
*/
public interface HomeAdvertiseService {

    int create(HomeAdvertise advertise);

    int delete(List<Long> ids);

    /**
     * 修改上下线状态
     * @param id 广告id
     * @param status 状态
     * @return
     */
    int updateStatus(Long id, Integer status);

    int update(Long id, HomeAdvertise ad);

    HomeAdvertise getById(Long id);

    /**
     * 分页查询
     * @param name 广告名
     * @param type 广告类型
     * @param endDate 结束日期 如 2018-12-26 严格按照这种格式
     * @param current
     * @param limit
     * @return 符合条件广告信息
     */
    IPage<HomeAdvertise> list(String name, Integer type, String endDate,
                              Integer current, Integer limit);
}
