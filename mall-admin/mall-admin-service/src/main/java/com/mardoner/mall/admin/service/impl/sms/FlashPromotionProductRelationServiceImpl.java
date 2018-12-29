package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.FlashPromotionProductRelation;
import com.mardoner.mall.admin.mapper.sms.FlashPromotionProductRelationMapper;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionProduct;
import com.mardoner.mall.admin.service.sms.FlashPromotionProductRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @description: 限时购商品关联 服务实现
* @className: FlashPromotionProductRelationServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/28 21:48
* @version 1.0
*/
@Service
public class FlashPromotionProductRelationServiceImpl
        implements FlashPromotionProductRelationService {

    @Resource(name = "flashPromotionProductRelationMapper")
    private FlashPromotionProductRelationMapper productRelationMapper;

    @Override
    public int createBatch(List<FlashPromotionProductRelation> relationList) {
        return productRelationMapper.insertList(relationList);
    }

    @Override
    public int update(Long id, FlashPromotionProductRelation relation) {
        relation.setId(id);
        return productRelationMapper.updateById(relation);
    }

    @Override
    public int delete(Long id) {
        return productRelationMapper.deleteById(id);
    }

    @Override
    public FlashPromotionProductRelation getById(Long id) {
        return productRelationMapper.selectById(id);
    }

    @Override
    public IPage<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId,
                                                Integer current, Integer limit) {
        Page<SmsFlashPromotionProduct> page = new Page<>(current, limit);
        return productRelationMapper.selectPageVO(page, flashPromotionId, flashPromotionSessionId);
    }

    @Override
    public int getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        FlashPromotionProductRelation queryEntity = new
                FlashPromotionProductRelation();
        queryEntity.setFlashPromotionId(flashPromotionId);
        queryEntity.setFlashPromotionSessionId(flashPromotionSessionId);
        QueryWrapper<FlashPromotionProductRelation> wrapper =
                new QueryWrapper<>(queryEntity);
        return productRelationMapper.selectCount(wrapper);
    }
}
