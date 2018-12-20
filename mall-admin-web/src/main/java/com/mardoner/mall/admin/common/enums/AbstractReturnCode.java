package com.mardoner.mall.admin.common.enums;

/**
* @Description:  通用返回基类
* @ClassName: AbstractReturnCode
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 9:29
* @Version 1.0
*/
public abstract class AbstractReturnCode implements ReturnCode{

    private Integer code;
    private String message;

    public AbstractReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
