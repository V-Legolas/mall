package com.mardoner.mall.admin.entity.cms;

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
 * @ClassName: CmsHelp
 * @Description: 内容管理系统之帮助表 实体类
 * @author Legolas-QQ:2500119268
 * @date 2018年12月18日
 * @Version 1.0
 */
@TableName("cms_help")
public class CmsHelp extends Model<CmsHelp>{

    @TableId(value = "id",type=IdType.AUTO)
    private Long id;

    @TableField("category_id")
    private Long categoryId;

    private String icon;

    private String title;

    @TableField("show_status")
    private Integer showStatus;

    @TableField("create_time")
    private Date createTime;

    @TableField("read_count")
    private Integer read_count;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRead_count() {
        return read_count;
    }

    public void setRead_count(Integer read_count) {
        this.read_count = read_count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
