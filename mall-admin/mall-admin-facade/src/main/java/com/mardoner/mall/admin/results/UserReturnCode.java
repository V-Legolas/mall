package com.mardoner.mall.admin.results;

import com.mardoner.mall.admin.enums.ReturnCode;

public enum UserReturnCode implements ReturnCode {
    USER_NOT_EXIST(10000,"该账号不存在！"),
    USER_SUSPEND(10001,"该账号已被冻结！"),
    WRONG_PASSWORD(10003,"您输入的密码不正确！"),
    ACCOUNT_LOCK(10004,"密码连续输入错误超过5次，账户被锁定半小时！"),
    VALIDATE_CODE_ERROR(10005,"验证码错误！"),
    DOUBLE_PASSWORD_ERROR(10006,"俩次密码输入不一致！"),
    PASSWORD_AUTHENTICATION_ERROR(10007,"密码长度8~16位，其中数字，字母和符号至少包含两种!"),
    ACCOUNT_USED(10008,"该用户名已被使用"),
    UNAUTHORIZED(401,"未认证"),
    VALIDATE_ERROR(404,"用户名或者密码错误！"),
    ;

    private Integer code;
    private String message;

    UserReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
