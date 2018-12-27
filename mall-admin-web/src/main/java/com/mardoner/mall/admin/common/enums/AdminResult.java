package com.mardoner.mall.admin.common.enums;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.enums.ReturnCode;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:  后台管理放回数据
* @ClassName: AdminResult
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 9:46
* @Version 1.0
*/
public class AdminResult extends BaseResult{

    public AdminResult(ReturnCode returnCode, Object data){
        super(returnCode.getCode(),returnCode.getMessage(),data);
    }

    public AdminResult(ReturnCode returnCode){
        super(returnCode.getCode(),returnCode.getMessage());
    }

    public AdminResult(Integer code, String message){
        super(code, message);
    }

    /** 分页数据处理 */
    public AdminResult(IPage page){
        this(CommonReturnCode.SUCCESS);
        Map<String,Object> result = new HashMap<>();
        result.put("pageSize",page.getSize());
        result.put("total",page.getTotal());
        result.put("totalPages",page.getPages());
        result.put("index",page.getCurrent());
        result.put("data",page.getRecords());
        this.setData(result);
    }

    /** 验证失败 */
    public AdminResult(BindingResult result){
        this(CommonReturnCode.BAD_REQUEST.getCode(),result.getFieldError().getDefaultMessage());
    }
}
