package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.mapper.oms.OmsOrderMapper;
import com.mardoner.mall.admin.pojo.dto.*;
import com.mardoner.mall.admin.service.oms.OmsOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:  订单管理 service
* @ClassName: OmsOrderServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 21:03
* @Version 1.0
*/
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder>
        implements OmsOrderService {

    @Override
    public List<OmsOrder> getList(OmsOrderQueryParam queryParam, Integer index, Integer limit) {
        return null;
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        return 0;
    }

    @Override
    public int close(List<Long> orderIds, String note) {
        return 0;
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return null;
    }

    @Override
    public int updateReceiveInfo(OmsReceiveInfoParam omsReceiveInfoParam) {
        return 0;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyInfo money) {
        return 0;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        return 0;
    }
}
