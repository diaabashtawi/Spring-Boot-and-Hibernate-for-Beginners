package com.bakeet.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CheckSecurityLogAspect {

    @Before("com.bakeet.aop.utilities.AOPExpressions.excludeGetterAndSetter()")
    public void checkSecurity() {
        System.out.println("===>User not authenticated");
    }
}
