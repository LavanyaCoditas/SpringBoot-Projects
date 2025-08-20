package com.example.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Run a hard 5k";
    }
}
