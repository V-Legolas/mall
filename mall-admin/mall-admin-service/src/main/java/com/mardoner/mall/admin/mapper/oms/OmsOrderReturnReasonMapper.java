package com.mardoner.mall.admin.mapper.oms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnReason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description:  订单退货原因
* @ClassName: OmsOrderReturnReasonMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 21:01
* @Version 1.0
*/
public interface OmsOrderReturnReasonMapper extends BaseMapper<OmsOrderReturnReason> {

    /**
     * 批量更新退货状态
     * @param ids 退货原因主表id
     * @param status 原因状态
     * @return 成功记录数
     */
    int updateStatusList(@Param("ids")List<Long> ids, @Param("status") Integer status);
}
