package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.FlashPromotion;
import com.mardoner.mall.admin.mapper.sms.FlashPromotionMapper;
import com.mardoner.mall.admin.service.sms.FlashPromotionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
* @description:  限时购
* @className: FlashPromotionServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/29 15:06
* @version 1.0
*/
@Service
public class FlashPromotionServiceImpl implements FlashPromotionService {

    @Resource(name = "flashPromotionMapper")
    private FlashPromotionMapper flashPromotionMapper;

    @Override
    public int create(FlashPromotion param) {
        return flashPromotionMapper.insert(param);
    }

    @Override
    public int update(Long id, FlashPromotion param) {
        param.setId(id);
        return flashPromotionMapper.updateById(param);
    }

    @Override
    public int delete(Long id) {
        return flashPromotionMapper.deleteById(id);
    }

    @Override
    public FlashPromotion getById(Long id) {
        return flashPromotionMapper.selectById(id);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        FlashPromotion setEntity = new FlashPromotion();
        setEntity.setId(id);
        setEntity.setStatus(status);
        return flashPromotionMapper.updateById(setEntity);
    }

    @Override
    public IPage<FlashPromotion> list(String keyword, Integer current, Integer limit) {
        IPage<FlashPromotion> page = new Page<>(current,limit);
        QueryWrapper<FlashPromotion> wrapper = new
                QueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)){
        	wrapper.eq("title", keyword);
        }
        return flashPromotionMapper.selectPage(page,wrapper);
    }
}
