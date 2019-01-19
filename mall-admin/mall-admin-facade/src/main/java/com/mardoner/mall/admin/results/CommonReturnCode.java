package com.mardoner.mall.admin.results;

import com.mardoner.mall.admin.enums.ReturnCode;

public enum CommonReturnCode implements ReturnCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    UNKNOWN(-1,"未知错误"),

    BAD_REQUEST(400,"请求参数出错"),
    FORBIDDEN(403,"禁止操作");

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
