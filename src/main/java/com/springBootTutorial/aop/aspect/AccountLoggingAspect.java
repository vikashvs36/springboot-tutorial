package com.springBootTutorial.aop.aspect;

import com.springBootTutorial.modal.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountLoggingAspect {

    @Before(value = "com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
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

    /*@Before("execution(* updateAccountBalance(..))")
    public void beforeBusinessService() {
        System.out.println("Before Logging Account Access.");
    }*/
}