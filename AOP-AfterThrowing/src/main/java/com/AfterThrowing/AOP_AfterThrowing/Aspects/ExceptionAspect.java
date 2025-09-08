package com.AfterThrowing.AOP_AfterThrowing.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class ExceptionAspect
{
    @AfterThrowing(
            pointcut = "com.AfterThrowing.AOP_AfterThrowing.Aspects.PointCutDeclaration.thePointcut()",
            throwing="theExc")

    public void throwTheException(JoinPoint joinPoint, Throwable theExc)
    {
        System.out.println("Exception occurred here  ======>>>>>  "+theExc);
        System.out.println("Method : "+joinPoint.getSignature().toShortString());
    }


}
