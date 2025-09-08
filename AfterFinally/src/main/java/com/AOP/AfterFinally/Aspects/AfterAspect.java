package com.AOP.AfterFinally.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class AfterAspect
{
    @After("com.AOP.AfterFinally.Aspects.PointCutDeclaration.thePointcut()")
      public void executeAfterMethod(JoinPoint joinPoint)
       {
           System.out.println(joinPoint.getSignature().toShortString()+"  : method got executed ");
           System.out.println("all resources released successfully");
       }
}
