package com.example.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Spend 30 minutes in batting practice";
    }
}
