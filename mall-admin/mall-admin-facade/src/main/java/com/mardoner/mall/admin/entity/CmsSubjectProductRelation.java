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
* @ClassName: CmsSubjectProuctRelation  
* @Description: 专题商品关联表 实体类
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_subject_product_relation")
public class CmsSubjectProductRelation extends Model<CmsSubjectProductRelation>{

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField(value = "subject_id")
	private Long subjectId;
	
	@TableField(value = "product_id")
	private Long productId;
	
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
