package com.mardoner.mall.admin.common.enums;

import com.mardoner.mall.admin.enums.ReturnCode;

public enum CommonReturnCode implements ReturnCode {
    SUCCESS(1,"操作成功"),
    FAILED(0,"操作失败"),
    UNKOWN(-1,"未知错误"),

    REQUEST_OK(200,"请求成功"),
    BAD_REQUEST(400,"请求参数出错"),
    FORBIDDEN(403,"禁止操作"),
    NOT_FOUND(404,"页面找不到了！"),
    SERVER_ERROR(500,"服务器错误"),
    REQUEST_TIMEOUT(408,"请求超时");



    /** 状态码 **/
    private Integer code;

    /** 消息 */
    private String message;

    CommonReturnCode(Integer code, String message) {
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
