package com.mardoner.mall.admin.common.enums;

import java.io.Serializable;

/**
* @Description:  统一结果返回类
* @ClassName: BaseResult
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 9:45
* @Version 1.0
*/
public class BaseResult extends AbstractReturnCode implements Serializable {
    private static final long serialVersionUID = 1L;

    private Object data;

    public BaseResult(Integer code, String message, Object data) {
        super(code, message);
        this.data = data;
    }

    public BaseResult(Integer code, String message) {
        super(code, message);
        this.data = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
