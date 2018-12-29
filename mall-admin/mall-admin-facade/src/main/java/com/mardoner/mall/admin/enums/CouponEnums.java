package com.mardoner.mall.admin.enums;

public enum CouponEnums implements ReturnCode{
    // 优惠券分类
    ALL_PUBLISH(0,"全场赠券"),
    MEMBER_PUBLISH(1,"会员赠券"),
    SHOPPING_PUBLISH(2,"购物赠券"),
    REGISTER_PUBLISH(3,"注册赠券"),

    // 使用地分类
    ALL_USE(0,"全场通用"),
    CATEGORY_USE(1,"指定分类使用"),
    PRODUCT_USE(2,"指定商品使用")

    ;

    private Integer code;
    private String message;

    CouponEnums(Integer code, String message) {
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
