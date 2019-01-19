package com.mardoner.mall.admin.component;

import com.mardoner.mall.admin.results.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
* @description:  spring 校验失败处理
* @className: BindingResultAspect
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/19 12:16
* @version 1.0
*/
@Aspect
@Order(2)
@Component
public class BindingResultAspect {
    @Pointcut("execution(public * com.mardoner.mall.admin.controller.*.*(..))")
    public void BindingResult(){

    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    return new CommonResult(result);
                }
            }
        }
        return joinPoint.proceed();
    }
}
