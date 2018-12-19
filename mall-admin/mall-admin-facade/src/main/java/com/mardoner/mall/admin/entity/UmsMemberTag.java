package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 用户标签表
* @ClassName: UmsMemberTag
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 18:55
* @Version 1.0
*/
@TableName("ums_member_tag")
public class UmsMemberTag extends Model<UmsMemberTag> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    /** 自动打标签完成订单数 */
    @TableField("finish_order_count")
    private Integer finishOrderCount;

    /** 自动打标签完成订单金额 */
    @TableField("finish_order_amount")
    private Double finishOrderAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinishOrderCount() {
        return finishOrderCount;
    }

    public void setFinishOrderCount(Integer finishOrderCount) {
        this.finishOrderCount = finishOrderCount;
    }

    public Double getFinishOrderAmount() {
        return finishOrderAmount;
    }

    public void setFinishOrderAmount(Double finishOrderAmount) {
        this.finishOrderAmount = finishOrderAmount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
