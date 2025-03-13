package com.bakeet.aop.utilities;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* com.bakeet.aop.repository.*.*(..))")
    void forRepositoryPackage() {}
    // Pointcut for getter method
    @Pointcut("execution(* com.bakeet.aop.repository.*.get*(..))")
    void getter(){}
    // Pointcut for setter method
    @Pointcut("execution(* com.bakeet.aop.repository.*.set*(..))")
    void setter(){}
    // Pointcut include package and exclude getter/setter
    @Pointcut("forRepositoryPackage() && !(getter() || setter())")
    public void excludeGetterAndSetter(){}
}
