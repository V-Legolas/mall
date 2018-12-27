package com.mardoner.mall.admin.service.impl.oms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.oms.OmsCompanyAddress;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.mapper.oms.OmsCompanyAddressMapper;
import com.mardoner.mall.admin.mapper.oms.OmsOrderReturnApplyMapper;
import com.mardoner.mall.admin.pojo.dto.param.OmsOrderReturnStatusParam;
import com.mardoner.mall.admin.pojo.dto.param.OmsReturnApplyQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.OmsOrderReturnApplyResult;
import com.mardoner.mall.admin.service.oms.OmsOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
        if(status.equals(1)){
            // 确认退货，退货中
            returnApply.setId(id);
            returnApply.setHandleMan(returnParam.getHandleMan());
            returnApply.setHandleNote(returnParam.getHandleNote());
            returnApply.setHandleTime(new Date());
            returnApply.setStatus(1);
            returnApply.setReturnAmount(new BigDecimal(returnParam.getReturnAmount()));
            returnApply.setCompanyAddressId(returnParam.getCompanyAddressId());
        }else if(status.equals(2)){
            // 完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveMan(returnParam.getReceiveMan());
            returnApply.setReceiveNote(returnParam.getReceiveNote());
            returnApply.setReceiveTime(new Date());
        }else if(status.equals(3)){
            // 拒绝退货
            returnApply.setId(id);
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

    @Override
    public int logicDelete(List<Long> ids) {
        UpdateWrapper<OmsOrderReturnApply> wrapper =
                new UpdateWrapper<>();
        wrapper.in("id",ids);

        // 拒绝申请，达到逻辑删除
        OmsOrderReturnApply setEntity = new OmsOrderReturnApply();
        setEntity.setStatus(OrderEnums.REFUSE_RETURN.getCode());
        return orderReturnApplyMapper.update(setEntity, wrapper);
    }

    @Override
    public IPage<OmsOrderReturnApply> list(OmsReturnApplyQueryParam param, Integer current, Integer limit) {
        // 查询实体
        OmsOrderReturnApply queryEntity = new OmsOrderReturnApply();
        queryEntity.setId(param.getId());
        queryEntity.setStatus(param.getStatus());
        queryEntity.setHandleMan(param.getHandleMan());

        // 模糊查询条件构建以及查询实体注入到条件构造器
        QueryWrapper<OmsOrderReturnApply> wrapper =
                new QueryWrapper<>(queryEntity);
        if(!StringUtils.isEmpty(param.getCreateTime())){
            wrapper.like("create_time",param.getCreateTime());
        }
        if(!StringUtils.isEmpty(param.getHandleTime())){
            wrapper.like("handle_time",param.getHandleTime());
        }
        if(!StringUtils.isEmpty(param.getNameOrPhone())){
            wrapper.like("return_name",param.getNameOrPhone()).or()
                    .like("return_phone",param.getNameOrPhone());
        }

        // 分页实体
        IPage<OmsOrderReturnApply> page = new Page<>(current,limit);
        return orderReturnApplyMapper.selectPage(page, wrapper);
    }
}
