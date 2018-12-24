package com.mardoner.mall.admin.enums;

/**
* @Description: 枚举常量字段定义
* @ClassName: StatusEnum
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/19 12:28
* @Version 1.0
*/
public enum StatusEnum {
    ADD_PERMISSION(1,"‘+’权限，即角色权限中含有的权限"),
    SUB_PERMISSION(-1,"'-'权限，即角色权限没有的无效权限"),

    FROZEN(0,"冻结"),
    NORMAL(1,"正常"),
    NON_NORMAL(0,"无效"),

    COMMON_MEMBER(1,"默认会员"),
    LEVEL_MEMBER(0,"非默认会员"),
    ;


    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
