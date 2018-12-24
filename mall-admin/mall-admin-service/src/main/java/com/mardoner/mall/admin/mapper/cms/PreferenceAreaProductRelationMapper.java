package com.mardoner.mall.admin.mapper.cms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.cms.CmsPreferenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  优选专区 商品关联
* @className: PreferenceAreaProductRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 20:35
* @version 1.0
*/
public interface PreferenceAreaProductRelationMapper
        extends BaseMapper<CmsPreferenceAreaProductRelation> {

    int insertList(@Param("list")List<CmsPreferenceAreaProductRelation> dataList);
}
