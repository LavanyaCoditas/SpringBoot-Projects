package com.lavanyaSpringBootProject.AOP_project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class Order0 {
    @Before("com.lavanyaSpringBootProject.AOP_project.aspect.PointcutExp.declaredPointcut()")

    public void reUseOfPointcut()
    {
        System.out.println("\nthis is the reuse of declared pointcut and ordered 0");
    }

}
