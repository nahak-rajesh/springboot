package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a Private Field For  the Dependency
    private Coach myCoach;

    // define a setter method for dependency injection
    @Autowired
    public void setMyCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    // define any methods for dependency injection
//    @Autowired
//    public void doSomeStuff(Coach theCoach) {
//        myCoach = theCoach;
//    }

    // define any methods for Field injection
//    private Coach getMyCoach;

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
