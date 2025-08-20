package com.example.spring_core_demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 minutes!!!!!";
    }
}
