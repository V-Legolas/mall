package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  会员阶梯价 mapper
* @className: ProductLadderMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 19:38
* @version 1.0
*/
public interface ProductLadderMapper extends BaseMapper<ProductLadder> {

    int insertList(@Param("list")List<ProductLadder> dataList);
}
