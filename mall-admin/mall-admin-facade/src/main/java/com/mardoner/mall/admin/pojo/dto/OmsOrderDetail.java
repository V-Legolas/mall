package com.mardoner.mall.admin.pojo.dto;

import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.entity.oms.OmsOrderItem;
import com.mardoner.mall.admin.entity.oms.OmsOrderOperateHistory;

import java.io.Serializable;
import java.util.List;

/**
* @Description:  订单详情
* @ClassName: OmsOrderDetail
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:24
* @Version 1.0
*/
public class OmsOrderDetail extends OmsOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 订单商品 */
    private List<OmsOrderItem> orderItemList;

    /** 订单操作记录 */
    private List<OmsOrderOperateHistory> orderOperateHistoryList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OmsOrderOperateHistory> getOrderOperateHistoryList() {
        return orderOperateHistoryList;
    }

    public void setOrderOperateHistoryList(List<OmsOrderOperateHistory> orderOperateHistoryList) {
        this.orderOperateHistoryList = orderOperateHistoryList;
    }
}
