package com.AOP.AfterFinally.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutDeclaration
{
    @Pointcut("execution( * com.AOP.AfterFinally.DAO.CalculatorDAO.*(..))")
    public void thePointcut()
    {
         //just a marker of pointcut
    }
}
