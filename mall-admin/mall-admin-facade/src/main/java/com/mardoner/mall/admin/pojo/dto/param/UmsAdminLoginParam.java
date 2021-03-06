package com.mardoner.mall.admin.pojo.dto.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
* @Description: 用户登录参数
* @ClassName: UmsAdminLoginParam
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 20:37
* @Version 1.0
*/
public class UmsAdminLoginParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
