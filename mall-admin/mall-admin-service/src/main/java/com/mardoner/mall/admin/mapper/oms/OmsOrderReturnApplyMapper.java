package com.mardoner.mall.admin.mapper.oms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;
import org.apache.ibatis.annotations.Param;

/**
* @Description:  退货订单处理 mapper
* @ClassName: OmsOrderReturnApplyMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:59
* @Version 1.0
*/
public interface OmsOrderReturnApplyMapper extends BaseMapper<OmsOrderReturnApply> {

    /**
     * 获取订单详情
     * @return 订单详情
     */
    OmsOrderReturnApplyResult detailOrder(@Param("orderId")Long id);
}
