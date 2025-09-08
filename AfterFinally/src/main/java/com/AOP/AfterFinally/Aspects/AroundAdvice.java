package com.AOP.AfterFinally.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AroundAdvice {
@Around("execution(* com.AOP.AfterFinally.Service.TrafficFortuneService.*(..))")
 public Object aroundGetFortune(
         ProceedingJoinPoint proceedingJoinPoint)throws Throwable
{
    //print out method we are advising
String method= proceedingJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>>> executing @Around on method : "+method);

    //get begin timestamp
    long begin = System.currentTimeMillis();

    //execute method
 Object result=null;
 try {
     result = proceedingJoinPoint.proceed();
 }
 catch (Exception e)
 {
     //steps to handle the exception or aproach
     System.out.println("@Around we have a problem :" + e);
     result="nothing exciting here : move along !";
 }

    //get ending timestamp
long end= System.currentTimeMillis();

    //compute duration
    long duration  = end- begin;
    System.out.println("\n =>>>> duration : "+ duration+ " seconds");

   return  result;
}



}
