package com.mardoner.mall.admin.enums;

/**
* @Description:  订单管理枚举常量类型定义
* @ClassName: OrderEnums
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/22 11:09
* @Version 1.0
*/
public enum OrderEnums implements ReturnCode{
    /** 订单状态 */
    NON_PAY(0,"待付款"),
    NON_DELIVERY(1,"待发货"),
    ALREADY_DELIVERY(2,"已经发货"),
    FINISHED(3,"订单已经完成"),
    CLOSE(4,"订单已经关闭"),
    INVALID(5,"订单无效"),

    /** 订单类型 */
    NORMAL_TYPE(0,"正常普通订单"),
    FLASH_TYPE(1,"秒杀订单"),

    /** 支付方式 */
    NOT_PAY(0,"未支付"),
    WECHAT_PAY(1,"微信支付"),
    ALI_PAY(2,"支付宝支付"),

    /** 订单来源 */
    APP_SOURCE(1,"app订单"),
    PC_SOURCE(0,"PC订单"),

    /** 发票类型 */
    NON_BILL(0,"不开发票"),
    ELECTRONIC_BILL(1,"电子发票"),
    PAPER_BILL(2,"纸质发票"),

    /** 删除状态 */
    DELETE(1,"订单已经删除"),
    NOT_DELETE(0,"订单还存在"),

    /** 是否为默认收货地址 */
    NOT_DEFAULT_RECEIVE_ADDRESS(0,"非默认收货地址"),
    DEFAULT_RECEIVE_ADDRESS(1,"默认收货地址"),

    /** 是否为默认发货地址 */
    NOT_DEFAULT_SEND_ADDRESS(0,"非默认发货地址"),
    DEFAULT_SEND_ADDRESS(1,"默认发货地址"),

    /** 是否启用 */
    USE(1,"启用"),
    NOT_USE(0,"不启用"),

    /** 订单退货状态 */
    WAIT_HANDLE(0,"待处理"),
    RETURNNING(1,"退货中"),
    RETURN_FINISHED(2,"已完成退货"),
    REFUSE_RETURN(3,"拒绝该退货申请")
    ;

    private Integer code;
    private String message;

    OrderEnums(Integer code, String message) {
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
