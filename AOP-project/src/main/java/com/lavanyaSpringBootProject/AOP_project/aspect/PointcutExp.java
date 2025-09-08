package com.lavanyaSpringBootProject.AOP_project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//usage of @Aspect is optional as we are not using any @before or such things in our class
@Aspect
public class PointcutExp
{
    @Pointcut("execution(public * com.lavanyaSpringBootProject.AOP_project.Service.*.*(..))")
    public void declaredPointcut()
    {

    }
}
