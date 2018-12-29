package com.mardoner.mall.admin.service.impl.sms;

import com.mardoner.mall.admin.entity.sms.FlashPromotionSession;
import com.mardoner.mall.admin.mapper.sms.FlashPromotionSessionMapper;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionSessionDetail;
import com.mardoner.mall.admin.service.sms.FlashPromotionProductRelationService;
import com.mardoner.mall.admin.service.sms.FlashPromotionSessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @description:  活动场次
* @className: FlashPromotionSessionServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/29 12:52
* @version 1.0
*/
@Service
public class FlashPromotionSessionServiceImpl
        implements FlashPromotionSessionService {

    @Resource(name = "flashPromotionSessionMapper")
    private FlashPromotionSessionMapper sessionMapper;

    @Resource(name = "flashPromotionProductRelationServiceImpl")
    private FlashPromotionProductRelationService relationService;

    @Override
    public int create(FlashPromotionSession promotionSession) {
        promotionSession.setCreateTime(LocalDateTime.now());
        return sessionMapper.insert(promotionSession);
    }

    @Override
    public int update(Long id, FlashPromotionSession promotionSession) {
        promotionSession.setId(id);
        return sessionMapper.updateById(promotionSession);
    }

    @Override
    public int delete(Long id) {
        return sessionMapper.deleteById(id);
    }

    @Override
    public int updateStatus(Long id,Integer status) {
        FlashPromotionSession setEntity = new
                FlashPromotionSession();
        setEntity.setId(id);
        setEntity.setStatus(status);
        return sessionMapper.updateById(setEntity);
    }

    @Override
    public FlashPromotionSession getById(Long id) {
        return sessionMapper.selectById(id);
    }

    @Override
    public List<FlashPromotionSession> list() {
        return sessionMapper.selectList(null);
    }

    @Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<FlashPromotionSession> list =
                sessionMapper.selectList(null);
        List<SmsFlashPromotionSessionDetail> detailList = list.stream().map(item -> {
            SmsFlashPromotionSessionDetail detail = new
                    SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(item,detail);
            detail.setProductCount(relationService.getCount(flashPromotionId, detail.getId()));
            return detail;
        }).collect(Collectors.toList());
        return detailList;
    }
}
