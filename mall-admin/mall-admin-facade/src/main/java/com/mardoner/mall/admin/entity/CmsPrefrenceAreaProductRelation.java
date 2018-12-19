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
* @ClassName: CmsPrefrenceAreaProductRelation  
* @Description: 实体类
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_prefrence_area_product_relation")
public class CmsPrefrenceAreaProductRelation 
	extends Model<CmsPrefrenceAreaProductRelation>{

	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	
	@TableField("prefrence_area_id")
	private Long prefrenceAreaId;
	
	@TableField("product_id")
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrefrenceAreaId() {
		return prefrenceAreaId;
	}

	public void setPrefrenceAreaId(Long prefrenceAreaId) {
		this.prefrenceAreaId = prefrenceAreaId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
