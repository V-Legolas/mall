package com.mardoner.mall.admin.entity.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mardoner.mall.admin.validator.FlagValidator;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:  商家退货理由 实体类
* @ClassName: OmsOrderReturnReason
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 18:24
* @Version 1.0
*/
@TableName("oms_order_return_reason")
public class OmsOrderReturnReason extends Model<OmsOrderReturnReason> {

    @TableId(type = IdType.AUTO)
    private Long id;
    /** 退货类型 名称 */

    private String name;

    private String sort;

    /** 0->不启用 1->启用 */
    @FlagValidator({"0","1"})
    private String status;

    @TableField("create_time")
    private Date createTime;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
