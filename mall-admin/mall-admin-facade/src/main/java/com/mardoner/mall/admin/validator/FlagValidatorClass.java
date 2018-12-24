package com.mardoner.mall.admin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
* @Description:  状态验证器绑定的类
* @ClassName: FlagValidatorClass
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:12
* @Version 1.0
*/
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {
    private String[] values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = false;
        if(value == null){
            // 状态为空，表示验证通过，使用默认值
            return true;
        }
        for (String s : values) {
            if(s.equals(String.valueOf(value))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
