package com.mardoner.mall.admin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobilePhoneClass implements ConstraintValidator<MobilePhone, String> {
    private String value;

    @Override
    public void initialize(MobilePhone constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            // 为null, 默认验证通过
            return true;
        }
        boolean isValid = false;
        if(value.matches("^1[3|4|5|7|8]\\d{9}$")){
            isValid = true;
        }
        return isValid;
    }
}
