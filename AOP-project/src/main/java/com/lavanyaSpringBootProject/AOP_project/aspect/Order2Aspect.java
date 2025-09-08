package com.lavanyaSpringBootProject.AOP_project.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Order2Aspect
{
    @Before("com.lavanyaSpringBootProject.AOP_project.aspect.PointcutExp.declaredPointcut()")

    public void pointcut1()
    {
        System.out.println("\nthis is the pointcut ordered 2");
    }
}
