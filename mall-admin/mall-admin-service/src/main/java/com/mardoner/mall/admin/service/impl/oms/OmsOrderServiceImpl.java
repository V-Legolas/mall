package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.entity.oms.OmsOrderOperateHistory;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.enums.StatusEnum;
import com.mardoner.mall.admin.mapper.oms.OmsOrderMapper;
import com.mardoner.mall.admin.mapper.oms.OmsOrderOperateHistoryMapper;
import com.mardoner.mall.admin.pojo.dto.param.OmsMoneyParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderDeliveryParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderQueryParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReceiveInfoParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderDetail;
import com.mardoner.mall.admin.service.oms.OmsOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource(name = "omsOrderMapper")
    private OmsOrderMapper orderMapper;
    @Resource(name = "omsOrderOperateHistoryMapper")
    private OmsOrderOperateHistoryMapper operateHistoryMapper;

    @Override
    public IPage<OmsOrder> getList(OmsOrderQueryParam queryParam, Integer index, Integer limit) {
        IPage<OmsOrder> page = new Page<>(index,limit);
        OmsOrder queryOrder = new OmsOrder();
        queryOrder.setDeleteStatus(StatusEnum.NOT_LOGIC_DELETE.getCode());          // 未被逻辑删除
        queryOrder.setOrderSn(queryParam.getOrderSn());
        queryOrder.setSourceType(queryParam.getSourceType());
        queryOrder.setStatus(queryOrder.getStatus());
        queryOrder.setOrderType(queryOrder.getOrderType());
        QueryWrapper<OmsOrder> query = new QueryWrapper<>(queryOrder);
        // 查询条件构造
        if(StringUtils.isNotEmpty(queryParam.getCreateTime())){
            query.like(true,"create_time",queryParam.getCreateTime());
        }
        if(StringUtils.isNotEmpty(queryParam.getReceiveNameOrPhone())){
            query.like(true,"receiver_phone",queryParam.getReceiveNameOrPhone())
                    .or().like("receiver_name",queryParam.getReceiveNameOrPhone());
        }
        return orderMapper.selectPage(page,query);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList, String operateName) {
        // 批量发货
        int count = orderMapper.delivery(deliveryParamList, OrderEnums.NON_DELIVERY.getCode(),
                OrderEnums.ALREADY_DELIVERY.getCode());
        // 添加订单修改记录
        List<OmsOrderOperateHistory> historyList =
                deliveryParamList.stream().map(deliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(deliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan(operateName);
                    history.setOrderStatus(OrderEnums.ALREADY_DELIVERY.getCode());
                    history.setNote(OrderEnums.ALREADY_DELIVERY.getMessage());
                    return history;
                }).collect(Collectors.toList());
        operateHistoryMapper.insertList(historyList);
        return count;
    }

    @Override
    public int close(List<Long> orderIds, String note, String operatorName) {
        // 关闭，取消订单集合
        // SET实体类
        OmsOrder setEntity = new OmsOrder();
        setEntity.setStatus(OrderEnums.CLOSE.getCode());
        // 条件构造 where
        QueryWrapper<OmsOrder> wrapper = new QueryWrapper<>();
        // 未被逻辑删除
        wrapper.eq("deleteStatus", StatusEnum.NOT_LOGIC_DELETE.getCode());
        wrapper.in("id",orderIds);
        int count  = orderMapper.update(setEntity,wrapper);

        // 更新操作记录
        List<OmsOrderOperateHistory> operateHistories = orderIds.stream().map(orderId -> {
           OmsOrderOperateHistory history = new OmsOrderOperateHistory();
           history.setOrderId(orderId);
           history.setOperateMan(operatorName);
           history.setOrderStatus(OrderEnums.CLOSE.getCode());
           history.setCreateTime(new Date());
           if(StringUtils.isEmpty(note)){
               history.setNote("订单关闭！");
           }else{
               history.setNote("订单关闭：" + note);
           }
           return history;
        }).collect(Collectors.toList());
        operateHistoryMapper.insertList(operateHistories);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        QueryWrapper<OmsOrder> wrapper = new QueryWrapper<>();
        wrapper.in("id",ids);
        OmsOrder setEntity = new OmsOrder();
        setEntity.setDeleteStatus(StatusEnum.LOGIC_DELETE.getCode());
        return orderMapper.update(setEntity, wrapper);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return orderMapper.getDetail(id);
    }

    @Override
    public int updateReceiveInfo(OmsReceiveInfoParam omsReceiveInfoParam, String operatorName) {
        // 根据订单id查询信息并更新
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(omsReceiveInfoParam,order,"status");
        order.setModifyTime(new Date());
        int count = orderMapper.updateById(order);
        // 插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(omsReceiveInfoParam.getId());
        history.setOperateMan(operatorName);
        history.setCreateTime(new Date());
        history.setNote("修改收货人信息");
        history.setOrderStatus(omsReceiveInfoParam.getStatus());
        operateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyParam money, String operatorName) {
        // 根据订单id查询信息并更新
        OmsOrder order = new OmsOrder();
        order.setId(money.getOrderId());
        order.setFreightAmount(money.getFreightAmount());
        order.setDiscountAmount(money.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = orderMapper.updateById(order);
        // 插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(money.getOrderId());
        history.setOperateMan(operatorName);
        history.setCreateTime(new Date());
        history.setNote("修改费用信息");
        history.setOrderStatus(money.getStatus());
        operateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status, String operatorName) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateById(order);
        // 插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setOperateMan(operatorName);
        history.setCreateTime(new Date());
        history.setNote("修改备注信息");
        history.setOrderStatus(status);
        operateHistoryMapper.insert(history);
        return count;
    }
}
