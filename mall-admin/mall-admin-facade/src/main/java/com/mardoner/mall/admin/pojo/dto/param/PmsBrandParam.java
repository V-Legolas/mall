package com.mardoner.mall.admin.pojo.dto.param;

import com.mardoner.mall.admin.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
* @Description:  创建品牌入参
* @ClassName: PmsBrandParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 9:57
* @Version 1.0
*/
@ApiModel(value = "创建品牌入参", description = "商家品牌的DTO")
public class PmsBrandParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌商家名称",required = true)
    @NotBlank(message = "商家名称不能为空")
    private String name;

    @ApiModelProperty(value = "品牌首字母")
    private String firstLetter;

    @ApiModelProperty("排序字段")
    @Min(value = 0,message = "排序字段最小为0")
    private Integer sort;

    @ApiModelProperty("是否为厂家制造商")
    @FlagValidator(value = {"0","1"}, message = "厂家状态验证不正确")
    private Integer factoryStatus;

    @ApiModelProperty("显示状态")
    @FlagValidator(value = {"0","1"},message = "显示状态不正确")
    private Integer showStatus;

    @ApiModelProperty("品牌logo")
    @NotEmpty(message = "品牌logo不能为空")
    private String logo;

    @ApiModelProperty("品牌大图")
    private String bigPic;

    @ApiModelProperty("品牌故事")
    private String brandStory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
