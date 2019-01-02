package com.mardoner.mall.admin.component;

import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.UserReturnCode;
import com.mardoner.mall.admin.common.util.JsonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @Description:  security 当未登录或者token失效的 处理
* @ClassName: RestAuthenticationEntryPoint
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 11:19
* @Version 1.0
*/
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JsonUtils.objToJson(
                new CommonResult(UserReturnCode.UNAUTHORIZED.getCode(),authException.getMessage())));
        response.getWriter().flush();
    }
}
