package com.bakheet.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut(
            "execution(* com.bakheet.mvc.controller.*.*(..))"
    )
    private void logControllerPackage() {
    }

    @Pointcut(
            "execution(* com.bakheet.mvc.service.*.*(..))"
    )
    private void logServicePackage() {
    }

    @Pointcut(
            "execution(* com.bakheet.mvc.repository.*.*(..))"
    )
    private void logRepositoryPackage() {
    }

    @Pointcut("logControllerPackage() || logServicePackage() || logRepositoryPackage()")
    private void loggingFlow() {
    }

    @Before("loggingFlow()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("-----> Before calling : " + methodName);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("-----> arguments : " + arg);
        }
    }

    @AfterReturning(
            pointcut = "loggingFlow()",
            returning = "returnValue"
    )
    private void afterReturning(JoinPoint joinPoint, Object returnValue) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("-----> @AfterReturning : " + methodName);
        logger.info("-----> returnValue : " + returnValue);
    }
}
