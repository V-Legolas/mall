package com.mardoner.mall.admin.common.util;

import com.mardoner.mall.admin.config.AdminUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
* @Description:  登录工具类
* @ClassName: SingletonLoginUtils
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 15:54
* @Version 1.0
*/
public class SingletonLoginUtils {

    private SingletonLoginUtils(){
        throw new AssertionError();
    }

    // TODO 验证码验证


    // 获取当前登录用户
    public static AdminUserDetails getUser()throws ProviderNotFoundException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
         || auth instanceof AnonymousAuthenticationToken){
            // 匿名认证也不行
            throw new ProviderNotFoundException("用户未登录");
        }else{
            return (AdminUserDetails) auth.getPrincipal();
        }
    }

    // 获取当前用户名
    public static String getUsername(){
        return getUser().getUsername();
    }
}
