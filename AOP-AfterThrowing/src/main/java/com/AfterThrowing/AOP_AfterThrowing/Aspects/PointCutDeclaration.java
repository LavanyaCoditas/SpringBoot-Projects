package com.AfterThrowing.AOP_AfterThrowing.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutDeclaration
{
    @Pointcut("execution(* com.AfterThrowing.AOP_AfterThrowing.DAO.ExceptionDAO.divide*(..))")
    public void thePointcut()
    {

    }
}
