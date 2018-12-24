package com.mardoner.mall.admin.mapper.oms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.oms.OmsOrder;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderDeliveryParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description:  订单
* @ClassName: OmsOrderMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 21:02
* @Version 1.0
*/
public interface OmsOrderMapper extends BaseMapper<OmsOrder> {

    /**
     * 批量发货
     * @param list 参数集合
     * @param  notDelivery 未发货状态
     * @param  alreadyDelivery 以发货状态
     * @return 成功记录数
     */
    int delivery(@Param("list")List<OmsOrderDeliveryParam> list,
                 @Param("notDelivery") Integer notDelivery,
                 @Param("alreadyDelivery") Integer alreadyDelivery);

    /**
     * 根据id查询订单详情
     * @param id 订单id
     * @return 订单详情
     */
    OmsOrderDetail getDetail(@Param("id")Long id);
}
