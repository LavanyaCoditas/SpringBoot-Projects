package com.example.spring_core_demo.rest;

import com.example.spring_core_demo.common.Coach;
import com.example.spring_core_demo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
//    @Autowired // field injection
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    //this will inject the TennicCoach dependency at priority as we have used qualifier
//    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    // setter injection - uses a setter method to set the dependency
/*    @Autowired
    public void setCoach(Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }

}
