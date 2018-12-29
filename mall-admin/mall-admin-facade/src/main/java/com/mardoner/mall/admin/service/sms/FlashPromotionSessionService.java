package com.mardoner.mall.admin.service.sms;

import com.mardoner.mall.admin.entity.sms.FlashPromotionSession;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionSessionDetail;

import java.util.List;

/**
* @description:  限时购场次管理
* @className: FlashPromotionSessionService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/27 19:07
* @version 1.0
*/
public interface FlashPromotionSessionService {

    int create(FlashPromotionSession promotionSession);

    int update(Long id, FlashPromotionSession promotionSession);

    int delete(Long id);

    /**
     * 更新场次启用状态
     * @param id 主键id
     * @param status 启用状态
     * @return 影响记录数
     */
    int updateStatus(Long id, Integer status);

    FlashPromotionSession getById(Long id);

    /**
     * 根据启用状态获取场次列表
     * @return
     */
    List<FlashPromotionSession> list();

    /**
     * 更具活动id获取所有场次详细信息
     * @param flashPromotionId 活动id
     * @return
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
