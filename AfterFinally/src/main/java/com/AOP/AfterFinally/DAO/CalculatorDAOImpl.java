package com.AOP.AfterFinally.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorDAOImpl implements CalculatorDAO{
    @Override
    public void divide(int a, int b) {
        System.out.println("\nDivision : "+(a/b));
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println("\nMultiplication: "+(a*b));
    }
}
