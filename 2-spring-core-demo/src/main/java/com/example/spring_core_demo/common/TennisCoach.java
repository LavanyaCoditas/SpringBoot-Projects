package com.example.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice your backhand volley";
    }
}
