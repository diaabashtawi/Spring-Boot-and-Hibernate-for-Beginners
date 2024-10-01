package com.deya.springcore.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In constructor of " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Track Coach";
    }
}
