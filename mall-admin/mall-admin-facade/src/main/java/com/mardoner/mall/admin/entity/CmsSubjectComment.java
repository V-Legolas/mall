package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ProjectName: mall-admin-facade
* @ClassName: CmsSubjectComment  
* @Description: 专题评论表 实体类  
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_subject_comment")
public class CmsSubjectComment extends Model<CmsSubjectComment>{

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	@TableField("subject_id")
	private Long subjectId;
	
	@TableField("member_nick_name")
	private String memberNickName;
	
	@TableField("member_icon")
	private String memberIcon;
	
	private String content;
	
	@TableField("create_time")
	private Date createTime;
	
	@TableField("show_status")
	private Integer showStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getMemberIcon() {
		return memberIcon;
	}

	public void setMemberIcon(String memberIcon) {
		this.memberIcon = memberIcon;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
