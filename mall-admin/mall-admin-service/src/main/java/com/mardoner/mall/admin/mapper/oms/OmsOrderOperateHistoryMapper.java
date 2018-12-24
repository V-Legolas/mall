package com.mardoner.mall.admin.mapper.oms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.oms.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description:  订单操作历史
* @ClassName: OmsOrderOperateHistoryMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/22 12:04
* @Version 1.0
*/
public interface OmsOrderOperateHistoryMapper extends BaseMapper<OmsOrderOperateHistory> {

    /**
     * 批量插入记录
     * @param operateHistoryList 记录集合
     * @return 操作影响记录数
     */
    Integer insertList(@Param("list") List<OmsOrderOperateHistory>operateHistoryList);
}
