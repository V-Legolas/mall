package com.mardoner.mall.admin.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.sms.FlashPromotionProductRelation;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionProduct;

import java.util.List;

/**
* @description:  限时购商品关联
* @className: FlashPromotionProductRelationService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 18:55
* @version 1.0
*/
public interface FlashPromotionProductRelationService {

    /**
     * 批量添加
     */
    int createBatch(List<FlashPromotionProductRelation> relationList);

    /**
     * 修改关联信息
     */
    int update(Long id, FlashPromotionProductRelation relation);

    /**
     * 删除关联
     * @param id 关联id
     * @return 操作影响记录数
     */
    int delete(Long id);

    FlashPromotionProductRelation getById(Long id);

    /**
     * 分页查询限时购信息
     * @param flashPromotionId 限时购信息主键id
     * @param flashPromotionSessionId 限时购场次id
     * @param current 当前页
     * @param limit 每页记录数
     * @return
     */
    IPage<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId,
                                         Integer current, Integer limit);

    /**
     * 根据活动和场次id获取商品关系数量
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    int getCount(Long flashPromotionId, Long flashPromotionSessionId);
}
