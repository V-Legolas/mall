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
* @ClassName: CmsSubject  
* @Description:  专题实体类
* @author whuan-QQ:2500129268 mardoner12p@gmail.com
* @date 2018年12月18日  
* @Version 1.0
 */
@TableName("cms_subject")
public class CmsSubject extends Model<CmsSubject>{

	@TableId(value = "id", type=IdType.AUTO)
	private Long id;
	
	@TableField("category_id")
	private Long categoryId;
	
	private String title;
	
	private String pic;
	
	@TableField("product_count")
	private Integer productCount;
	
	@TableField("recommend_status")
	private Integer recommendStatus;
	
	@TableField("create_time")
	private Date createTime;
	
	@TableField("collect_count")
	private Integer collectCount;
	
	@TableField("read_count")
	private Integer readCount;
	
	@TableField("comment_count")
	private Integer commentCount;
	
	@TableField("album_pics")
	private String albumPics;
	
	private String description;
	
	@TableField("show_status")
	private Integer showStatus;
	
	private String content;
	
	@TableField("forward_count")
	private Integer forwardCount;
	
	@TableField("category_name")
	private String categoryName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Integer getRecommendStatus() {
		return recommendStatus;
	}

	public void setRecommendStatus(Integer recommendStatus) {
		this.recommendStatus = recommendStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getAlbumPics() {
		return albumPics;
	}

	public void setAlbumPics(String albumPics) {
		this.albumPics = albumPics;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getForwardCount() {
		return forwardCount;
	}

	public void setForwardCount(Integer forwardCount) {
		this.forwardCount = forwardCount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
