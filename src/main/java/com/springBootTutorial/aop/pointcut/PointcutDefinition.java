package com.springBootTutorial.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDefinition {

    @Pointcut("within(com.springBootTutorial.service..*)")
    public void serviceLayer() { }
}
