package com.example.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Inject properties for: coach.name && team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teamInfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "CoachName : " + coachName + " ,TeamName : " + teamName;
    }

    // expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

//     expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is Your lucky Day!";
    }
}
