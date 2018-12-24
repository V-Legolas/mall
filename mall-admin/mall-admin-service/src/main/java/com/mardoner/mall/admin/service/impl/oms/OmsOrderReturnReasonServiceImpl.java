package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnReason;
import com.mardoner.mall.admin.enums.StatusEnum;
import com.mardoner.mall.admin.mapper.oms.OmsOrderReturnReasonMapper;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnReasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:  退货缘由
* @ClassName: OmsOrderReturnReasonServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 21:10
* @Version 1.0
*/
@Service
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonMapper,
        OmsOrderReturnReason> implements OmsOrderReturnReasonService {

    @Resource(name = "omsOrderReturnReasonMapper")
    private OmsOrderReturnReasonMapper returnReasonMapper;

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        if(!status.equals(StatusEnum.NORMAL.getCode()) &&
                !status.equals(StatusEnum.NON_NORMAL.getCode())){
            // 无效状态
            return 0;
        }
        return returnReasonMapper.updateStatusList(ids,status);
    }
}
