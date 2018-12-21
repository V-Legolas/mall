package com.mardoner.mall.admin.pojo.dto;

import com.mardoner.mall.admin.entity.oms.OmsCompanyAddress;
import com.mardoner.mall.admin.entity.oms.OmsOrderReturnApply;

/**
* @Description:  售后退货申请处理结果 DTO
* @ClassName: OmsOrderReturnApplyResult
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 19:52
* @Version 1.0
*/
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {

    /** 退货地址详细信息 */
    private OmsCompanyAddress companyAddress;

    public OmsCompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(OmsCompanyAddress companyAddress) {
        this.companyAddress = companyAddress;
    }
}
