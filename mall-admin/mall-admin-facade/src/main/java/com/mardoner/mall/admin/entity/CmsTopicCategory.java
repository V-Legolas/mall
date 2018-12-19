package com.mardoner.mall.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 
* @ProjectName: mall-admin-facade
* @ClassName: CmsTopicCategory  
* @Description: 主题活动分类表 实体类  
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_topic_category")
public class CmsTopicCategory extends Model<CmsTopicCategory>{

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	private String name;

	/** 分类图标 */
	private String icon;

	/** 专题数量 */
	@TableField("subject_count")
	private Integer subjectCount;
	
	@TableField("show_status")
	private Integer showStatus;
	
	private Integer sort;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
