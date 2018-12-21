package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.mapper.oms.OmsOrderReturnApplyMapper;
import com.mardoner.mall.admin.pojo.dto.OmsOrderReturnApplyResult;
import com.mardoner.mall.admin.pojo.dto.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnApplyService;
import org.springframework.stereotype.Service;

/**
* @Description:  订单退货管理
* @ClassName: OmsOrderReturnApplyServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 21:05
* @Version 1.0
*/
@Service
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyMapper,
        OmsOrderReturnApply> implements OmsOrderReturnApplyService {

    @Override
    public int updateStatus(Long id, OmsOrderReturnStatusParam returnParam) {
        return 0;
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return null;
    }
}
