package com.mardoner.mall.admin.entity.cms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 
* @ProjectName: mall-admin-facade
* @ClassName: CmsHelpCategory  
* @Description: 管理系统 帮助分类表实体类
* @author Legolas-QQ:2500119268 
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_help_cateogry")
public class CmsHelpCategory extends Model<CmsHelpCategory>{

	@TableId(value = "id", type=IdType.AUTO)
	private Long id;
	
	private String name;
	
	private String icon;
	
	@TableField("help_count")
	private Integer helpCount;
	
	@TableField("show_status")
	private Integer showStatus;
	
	private Integer sort;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getHelpCount() {
		return helpCount;
	}

	public void setHelpCount(Integer helpCount) {
		this.helpCount = helpCount;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
