package com.mardoner.mall.admin.entity.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description:  订单设置表 实体类
* @ClassName: OmsOrderSetting
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/21 18:29
* @Version 1.0
*/
@TableName("oms_order_setting")
public class OmsOrderSetting extends Model<OmsOrderSetting> {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 秒杀订单持续时间 */
    @TableField("flash_order_overtime")
    private Integer flashOrderOvertime;

    /** 正常订单持续时间 */
    @TableField("normal_order_overtime")
    private Integer normalOrderOvertime;

    /** 发货多少天后自动确认收货 */
    @TableField("confirm_overtime")
    private Integer confirmOvertime;

    /** 收货后自动确认完成订单，不能申请售后时间 */
    @TableField("finish_overtime")
    private Integer finishOvertime;

    /** 订单完成评论自动好评时间 */
    @TableField("comment_overtime")
    private Integer commentOvertime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlashOrderOvertime() {
        return flashOrderOvertime;
    }

    public void setFlashOrderOvertime(Integer flashOrderOvertime) {
        this.flashOrderOvertime = flashOrderOvertime;
    }

    public Integer getNormalOrderOvertime() {
        return normalOrderOvertime;
    }

    public void setNormalOrderOvertime(Integer normalOrderOvertime) {
        this.normalOrderOvertime = normalOrderOvertime;
    }

    public Integer getConfirmOvertime() {
        return confirmOvertime;
    }

    public void setConfirmOvertime(Integer confirmOvertime) {
        this.confirmOvertime = confirmOvertime;
    }

    public Integer getFinishOvertime() {
        return finishOvertime;
    }

    public void setFinishOvertime(Integer finishOvertime) {
        this.finishOvertime = finishOvertime;
    }

    public Integer getCommentOvertime() {
        return commentOvertime;
    }

    public void setCommentOvertime(Integer commentOvertime) {
        this.commentOvertime = commentOvertime;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
