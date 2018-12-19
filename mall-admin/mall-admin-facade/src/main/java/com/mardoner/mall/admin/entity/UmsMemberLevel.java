package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
* @Description: 会员等级
* @ClassName: UmsMemberLevel
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 17:15
* @Version 1.0
*/
@TableName("ums_member_level")
public class UmsMemberLevel extends Model<UmsMemberLevel> {

    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;

    private String name;

    /** 共拥有的成长值 */
    @TableField("growth_point")
    private Integer growthPoint;

    /** 是否是默认等级 */
    @TableField("default_status")
    private Integer defaultStatus;

    /** 免运费标准 */
    @TableField("free_freight_point")
    private Double freeFreightPoint;

    /** 每次评价获取的成长值 */
    @TableField("comment_growth_point")
    private Integer commentGrowthPoint;

    /** 是否有免邮特权 */
    @TableField("priviledge_free_freight")
    private Integer privilegeFreeFreight;

    /** 是否有签到特权 */
    @TableField("priviledge_sign_in")
    private Integer privilegeSignIn;

    /** 评论获得奖励特权 */
    @TableField("priviledge_comment")
    private Integer privilegeComment;

    /** 专享活动特权 */
    @TableField("priviledge_promotion")
    private Integer provilegePromotion;

    /** 商品会员价特权 */
    @TableField("priviledge_member_price")
    private Integer privilegeMemberPrice;

    /** 生日活动 特权 */
    @TableField("priviledge_birthday")
    private Integer privilegeBirthday;

    private String note;

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

    public Integer getGrowthPoint() {
        return growthPoint;
    }

    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Double getFreeFreightPoint() {
        return freeFreightPoint;
    }

    public void setFreeFreightPoint(Double freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    public Integer getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    public void setCommentGrowthPoint(Integer commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    public Integer getPrivilegeFreeFreight() {
        return privilegeFreeFreight;
    }

    public void setPrivilegeFreeFreight(Integer privilegeFreeFreight) {
        this.privilegeFreeFreight = privilegeFreeFreight;
    }

    public Integer getPrivilegeSignIn() {
        return privilegeSignIn;
    }

    public void setPrivilegeSignIn(Integer privilegeSignIn) {
        this.privilegeSignIn = privilegeSignIn;
    }

    public Integer getPrivilegeComment() {
        return privilegeComment;
    }

    public void setPrivilegeComment(Integer privilegeComment) {
        this.privilegeComment = privilegeComment;
    }

    public Integer getProvilegePromotion() {
        return provilegePromotion;
    }

    public void setProvilegePromotion(Integer provilegePromotion) {
        this.provilegePromotion = provilegePromotion;
    }

    public Integer getPrivilegeMemberPrice() {
        return privilegeMemberPrice;
    }

    public void setPrivilegeMemberPrice(Integer privilegeMemberPrice) {
        this.privilegeMemberPrice = privilegeMemberPrice;
    }

    public Integer getPrivilegeBirthday() {
        return privilegeBirthday;
    }

    public void setPrivilegeBirthday(Integer privilegeBirthday) {
        this.privilegeBirthday = privilegeBirthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
