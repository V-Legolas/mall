package com.mardoner.mall.admin.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
* @Description:  状态验证器
* @ClassName: FlagValidator
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 10:12
* @Version 1.0
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    String[] value() default {};

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
