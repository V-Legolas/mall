package com.mardoner.mall.admin.service.oms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnReason;

import java.util.List;

/**
* @Description:  订单退货原因 service
* @ClassName: OmsOrderReturnReasonService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 19:57
* @Version 1.0
*/
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReason> {

    /**
     * 批量修改退货原因状态
     * @param ids id集合
     * @param status 状态
     * @return 成功记录数
     */
    int updateStatus(List<Long> ids, Integer status);
}
