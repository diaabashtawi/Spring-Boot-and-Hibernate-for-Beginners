package com.bakeet.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ManageTransactionLogAspect {

    @Before("com.bakeet.aop.utilities.AOPExpressions.excludeGetterAndSetter()")
    public void manageTransaction() {
        System.out.println("===>Manage Transaction started");
    }
}
