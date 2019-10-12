package com.springBootTutorial.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountLoggingAspect {

    @Before(value = "com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void beforeAccountMethodExecution() {
        System.out.println("Before Logging Account Access.");
    }

    @After("com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void afterAccountMethodExecution() {
        System.out.println("After Logging Account Access.");
    }

}
