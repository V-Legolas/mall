package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.MemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  会员价
* @className: MemberPriceMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/24 20:03
* @version 1.0
*/
public interface MemberPriceMapper extends BaseMapper<MemberPrice> {

    int insertList(@Param("list")List<MemberPrice> dataList);
}
