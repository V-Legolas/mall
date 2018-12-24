package com.mardoner.mall.admin.mapper.cms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.cms.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  专题商品关联
* @className: SubjectProductRelationMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 20:32
* @version 1.0
*/
public interface SubjectProductRelationMapper extends BaseMapper<CmsSubjectProductRelation> {

    int insertList(@Param("list") List<CmsSubjectProductRelation> dataList);
}
