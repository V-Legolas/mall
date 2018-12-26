package com.mardoner.mall.admin.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobilePhoneClass.class)
public @interface MobilePhone {

    String value() default "";

    String message() default "Please input true phone number!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payLoad() default {};
}
