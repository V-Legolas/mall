package com.mardoner.mall.admin.common.base;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;

import java.beans.PropertyEditorSupport;

/**
* @Description:  所有Controller父类，主要是防止xss攻击
* @ClassName: IController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/19 21:26
* @Version 1.0
*/
public interface IController {

    /**
     * 初始化数据绑定，将前端传递的数据进行HTML转义，防止XSS攻击
     * @param binder 传递的绑定数据
     */
    default void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new PropertyEditorSupport(){
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(text == null ? "" : StringEscapeUtils.escapeHtml4(text.trim()));
            }
        });
    }

}
