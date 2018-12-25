package com.mardoner.mall.admin.service.oms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReturnApplyQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;

import java.util.List;

/**
* @Description:  退货申请业务逻辑接口
* @ClassName: OmsOrderReturnApplyService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 17:09
* @Version 1.0
*/
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApply> {

    /**
     * 更新退货状态
     * @param id 退货服务订单id
     * @param returnParam 状态更新需要的参数
     */
    int updateStatus(Long id, OmsOrderReturnStatusParam returnParam);

    /**
     * 根据id获取最新退后详情
     * @param id 服务id
     * @return 退货详情
     */
    OmsOrderReturnApplyResult getItem(Long id);

    /**
     * 批量删除订单申请（逻辑删除） 把状态改为拒绝
     * @param ids 订单申请集合
     * @return 操作记录数
     */
    int logicDelete(List<Long> ids);

    /**
     * 分页筛选订单退货信息
     * @param param 筛选条件
     * @param current 当前页
     * @param limit 每页记录数
     * @return 符合条件记录集合
     */
    IPage<OmsOrderReturnApply> list(OmsReturnApplyQueryParam param,
                                          Integer current,
                                          Integer limit);
}
