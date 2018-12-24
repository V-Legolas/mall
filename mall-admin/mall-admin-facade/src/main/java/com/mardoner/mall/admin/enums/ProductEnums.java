package com.mardoner.mall.admin.enums;

public enum ProductEnums implements ReturnCode{

    /** 商品attribute类型 */
    ATTR_TYPE(0,"规格"),
    PARAM_TYPE(1,"参数"),

    ;

    private Integer code;
    private String message;

    ProductEnums(Integer code, String message) {
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
