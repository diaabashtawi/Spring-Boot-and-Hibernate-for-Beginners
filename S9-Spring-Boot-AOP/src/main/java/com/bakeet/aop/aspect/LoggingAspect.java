package com.bakeet.aop.aspect;

import com.bakeet.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {


    @Around("execution(* com.bakeet.aop.service.*.getTraffic(..))")
    public Object getTraffic(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("===> Executing @Around on method : " + methodName);
//        long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println("Exception in @Around on method : " + methodName + e.getMessage());
            result = "Heavy Traffic on API call";
            // rethrow exception
            //throw e;
        }

//        long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("===> Executeion Time : " + executionTime / 1000.0 + " seconds");
        return result;
    }


    @After(
            "execution(* com.bakeet.aop.repository.AccountRepository.findAccounts(..))"
    )
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @After (finally) on method : " + methodName);
    }


    @AfterThrowing(
            pointcut = "execution(* com.bakeet.aop.repository.AccountRepository.findAccounts(..))",
            throwing = "throwable"
    )
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable throwable) {
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterThrowing on method : " + methodName);
        System.out.println("===> The exception is : " + throwable);
    }

    @AfterReturning(
            pointcut = "execution(* com.bakeet.aop.repository.AccountRepository.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterReturning on method : " + method);
        System.out.println("===> The result is : " + result);
        convertAcountFirstNameAndLastNameToUpperCase(result);
        System.out.println("===> The result is : " + result);

    }

    private void convertAcountFirstNameAndLastNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            String firstName = account.getFirstName().toUpperCase();
            String lastName = account.getLastName().toUpperCase();
            account.setFirstName(firstName);
            account.setLastName(lastName);
        }
    }

    @Before("com.bakeet.aop.utilities.AOPExpressions.excludeGetterAndSetter()")
    private void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("===>Executing method:  looging something");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg: " + arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account: " + account.getFirstName() + " " + account.getLastName());
            }
        }
    }

}
