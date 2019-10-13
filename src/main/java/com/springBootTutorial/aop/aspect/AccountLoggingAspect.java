package com.springBootTutorial.aop.aspect;

import com.springBootTutorial.annotation.Auditable;
import com.springBootTutorial.modal.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountLoggingAspect {

    /*@Before(value = "com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void beforeAccountMethodExecution(JoinPoint joinPoint) {
        // Get the class name from JoinPoint
        String className = joinPoint.getTarget().getClass().getName();
        // Get the method name from JoinPoint
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before Logging "+className+"."+methodName+"().");
    }

    @After("com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void afterAccountMethodExecution() {
        System.out.println("After Logging Account Access.");
    }

    @AfterReturning(value = "execution(* getAccount(..))", returning = "returnValue")
    public void afterReturningAccountMethodExecution(Account returnValue) {
        System.out.println("AfterReturning Account Access. ReturnValue : "+returnValue);
        if (returnValue != null) returnValue.setAmount(returnValue.getAmount()+500);
    }

    @AfterThrowing(value = "execution(* isExistAccount(..))", throwing = "npe")
    public void afterThrowingAccountMethodExecution(NullPointerException npe) {
        System.out.println("AfterThrowing Logging Account Access. Exception : "+npe);
    }*/

    /*@Around("execution(* com.springBootTutorial.service.AccountServiceImpl.getAccount(..))")
    public Object aroundAdviceMethodExecution(ProceedingJoinPoint joinPoint) {
        System.out.println("Before Advice logging Account Access.");
        Object value=null;
        try {
            value = joinPoint.proceed();
        }catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        System.out.println("After Advice logging Account Access");
        System.out.println("Returning Advice : "+value);
        return value;
    }*/

    /*@Before("execution(* com.springBootTutorial.service.AccountServiceImpl.getAccount(..))")
    public void beforeBusinessService() {
        System.out.println("Before Logging Account Access.");
    }*/

    /*@Before("execution(* com.springBootTutorial.service.AccountServiceImpl.getAccount(..)) && args(accountNumber)")
    public void beforeAccountMethodExecution(String accountNumber) {
        System.out.println("Before Logging. AccountNumber : "+accountNumber);
    }*/

    @Before("execution(* com.springBootTutorial.service.AccountServiceImpl.getAccount(..)) && @annotation(auditable)" )
    public void beforeAccountMethodExecution(Auditable auditable) {
        System.out.println("Value from Auditable annotation : "+auditable.value());
    }
}
