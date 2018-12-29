package com.mardoner.mall.admin.mapper.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.FlashPromotionProductRelation;
import com.mardoner.mall.admin.pojo.dto.vo.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: 商品限时购与商品关系表 mapper接口
* @className: FlashPromotionProductRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018-12-27
* @version 1.0
*/
public interface FlashPromotionProductRelationMapper extends BaseMapper<FlashPromotionProductRelation> {

    /**
     * 批量插入
     * @param relationList 插入记录集合
     * @return 操作记录数
     */
    int insertList(@Param("list") List<FlashPromotionProductRelation> relationList);

    /**
     * 分页多表查询, 某个活动某场次下的商品信息
     * @param page 分页信息对象
     * @param flashPromotionId 活动id
     * @param flashPromotionSessionId 场次id
     * @return
     */
    IPage<SmsFlashPromotionProduct> selectPageVO(Page page,@Param("flashPromotionId")Long flashPromotionId,
                                                 @Param("flashPromotionSessionId")Long flashPromotionSessionId);
}
