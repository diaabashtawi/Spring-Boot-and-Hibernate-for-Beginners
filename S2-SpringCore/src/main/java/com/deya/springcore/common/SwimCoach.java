package com.deya.springcore.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach 1000 meters as a warm up";
    }
}
