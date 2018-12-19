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
* @ClassName: CmsMemberReport  
* @Description: 成员报告表 实体类 
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_member_report")
public class CmsMemberReport extends Model<CmsMemberReport>{

	@TableId(value = "id",type = IdType.AUTO)
	private Long id;

	/** 举报类型 商品评价/话题内容/用户评论 */
	@TableField("report_type")
	private Integer reportType;

	/** 举报人名称 */
	@TableField("report_member_name")
	private String reportMemberName;
	
	@TableField("create_time")
	private Date createTime;
	
	@TableField("report_object")
	private String reportObject;

	/** 举报状态  处理/未处理*/
	@TableField("report_status")
	private Integer reportStatus;

	/** 处理结果 无效/有效/恶意 */
	@TableField("handle_status")
	private Integer handleStatus;
	
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public String getReportMemberName() {
		return reportMemberName;
	}

	public void setReportMemberName(String reportMemberName) {
		this.reportMemberName = reportMemberName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReportObject() {
		return reportObject;
	}

	public void setReportObject(String reportObject) {
		this.reportObject = reportObject;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(Integer handleStatus) {
		this.handleStatus = handleStatus;
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
