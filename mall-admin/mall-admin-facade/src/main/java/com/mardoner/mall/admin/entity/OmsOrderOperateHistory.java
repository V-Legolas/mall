package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 商品操作记录
* @ClassName: OmsOrderOperateHistory
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 16:04
* @Version 1.0
*/
@TableName("oms_order_operate_history")
public class OmsOrderOperateHistory extends Model<OmsOrderOperateHistory> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // TODO 其它字段定义


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
