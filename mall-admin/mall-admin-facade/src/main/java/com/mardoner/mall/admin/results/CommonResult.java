package com.mardoner.mall.admin.results;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.enums.ReturnCode;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:  后台管理放回数据
* @ClassName: CommonResult
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 9:46
* @Version 1.0
*/
public class CommonResult extends BaseResult{

    public CommonResult(ReturnCode returnCode, Object data){
        super(returnCode.getCode(),returnCode.getMessage(),data);
    }

    public CommonResult(ReturnCode returnCode){
        super(returnCode.getCode(),returnCode.getMessage());
    }

    public CommonResult(Integer code, String message){
        super(code, message);
    }

    /** 分页数据处理 */
    public CommonResult(IPage page){
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
    public CommonResult(BindingResult result){
        this(CommonReturnCode.BAD_REQUEST.getCode(),result.getFieldError().getDefaultMessage());
    }
}
