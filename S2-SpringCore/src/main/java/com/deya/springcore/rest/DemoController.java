package com.deya.springcore.rest;

import com.deya.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define private field for the dependency
    private final Coach coach;

    @Autowired
    public DemoController(
            @Qualifier("swim") Coach firstCoach) {
        System.out.println("In constructor of " + getClass().getSimpleName());
        this.coach = firstCoach;
    }


    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

}
 