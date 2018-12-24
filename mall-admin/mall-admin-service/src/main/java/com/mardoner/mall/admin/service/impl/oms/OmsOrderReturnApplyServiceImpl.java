package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsCompanyAddress;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.mapper.oms.OmsCompanyAddressMapper;
import com.mardoner.mall.admin.mapper.oms.OmsOrderReturnApplyMapper;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

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

    @Resource(name = "omsOrderReturnApplyMapper")
    private OmsOrderReturnApplyMapper orderReturnApplyMapper;
    @Resource(name = "omsCompanyAddressMapper")
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public int updateStatus(Long id, OmsOrderReturnStatusParam returnParam) {
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        Integer status = returnParam.getStatus();
        returnApply.setId(returnParam.getId());
        if(status.equals(1)){
            // 确认退货，退货中
            returnApply.setId(returnApply.getId());
            returnApply.setHandleMan(returnParam.getHandleMan());
            returnApply.setHandleNote(returnParam.getHandleNote());
            returnApply.setHandleTime(new Date());
            returnApply.setStatus(1);
            returnApply.setReturnAmount(new BigDecimal(returnParam.getReturnAmount()));
            returnApply.setCompanyAddressId(returnParam.getCompanyAddressId());
        }else if(status.equals(2)){
            // 完成退货
            returnApply.setId(returnParam.getId());
            returnApply.setStatus(2);
            returnApply.setReceiveMan(returnParam.getReceiveMan());
            returnApply.setReceiveNote(returnParam.getReceiveNote());
            returnApply.setReceiveTime(new Date());
        }else if(status.equals(3)){
            // 拒绝退货
            returnApply.setId(returnParam.getId());
            returnApply.setStatus(3);
            returnApply.setHandleNote(returnParam.getHandleNote());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(returnParam.getHandleMan());
        }else{
            return 0;
        }
        return orderReturnApplyMapper.insert(returnApply);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        OmsOrderReturnApplyResult result = new OmsOrderReturnApplyResult();
        // 查询退货相关信息
        OmsOrderReturnApply returnApply = orderReturnApplyMapper.selectById(id);
        BeanUtils.copyProperties(returnApply, result);
        // 查询卖家地址信息
        OmsCompanyAddress address =
                companyAddressMapper.selectById(returnApply.getCompanyAddressId());
        result.setCompanyAddress(address);
        return result;
    }
}
