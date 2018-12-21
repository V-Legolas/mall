package com.mardoner.mall.admin.service.oms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.pojo.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description:  订单管理业务逻辑接口
* @ClassName: OmsOrderService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 20:00
* @Version 1.0
*/
public interface OmsOrderService extends IService<OmsOrder> {

    /** 根据条件分页查询
     * @param queryParam 查询条件对象
     * @param index 当前页
     * @param limit 每页显示记录条数
     * @return 符合条件的集合
     */
    List<OmsOrder> getList(OmsOrderQueryParam queryParam, Integer index, Integer limit);

    /**
     * 批量发货
     * @param deliveryParamList 发货信息
     * @return 成功记录数
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     * @param orderIds 订单id集合
     * @param note 备注
     * @return 成功记录数
     */
    @Transactional
    int close(List<Long> orderIds, String note);

    /**
     * 获取指定订单详情
     * @param id 订单id
     * @return 订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 更改订单收货信息
     * @param omsReceiveInfoParam 订单新的收货信息
     * @return 成功修改记录数
     */
    @Transactional
    int updateReceiveInfo(OmsReceiveInfoParam omsReceiveInfoParam);

    /**
     * 修改订单费用信息
     * @param money 订单费用
     * @return 成功记录数
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfo money);

    /**
     * 修改订单备注
     * @param id 订单id
     * @param note 新的订单备注
     * @param status 订单状态
     * @return 成功记录数
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);
}
