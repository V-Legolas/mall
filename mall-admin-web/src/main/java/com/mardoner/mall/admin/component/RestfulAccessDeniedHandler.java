package com.mardoner.mall.admin.component;

import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.util.JsonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @Description:  当前用户权限不足处理器
* @ClassName: RestfulAccessDeniedHandler
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 11:37
* @Version 1.0
*/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JsonUtils.objToJson(
                new AdminResult(CommonReturnCode.FORBIDDEN.getCode(),accessDeniedException.getMessage())));
        response.getWriter().flush();
    }
}
