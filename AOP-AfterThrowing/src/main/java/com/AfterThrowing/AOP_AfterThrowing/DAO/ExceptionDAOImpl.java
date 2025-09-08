package com.AfterThrowing.AOP_AfterThrowing.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class ExceptionDAOImpl implements ExceptionDAO{

    @Override
    public int divideNumber(int a, int b) {
        return a/b;
    }
}
