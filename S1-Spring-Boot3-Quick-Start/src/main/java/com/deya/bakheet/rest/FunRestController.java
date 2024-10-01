package com.deya.bakheet.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value(
            "${coach.name}"
    )
    private String coachName;
    @Value(
            "${team.name}"
    )
    private String teamName;

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach Name: " + coachName + ", Team Name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Welcome to Section 1 - Spring Boot 3 Quick Start";
    }

    @GetMapping("/aboutUs")
    public String aboutUsPAge(){
        return "Welcome To About Us Page - Deya Bakheet";
    }

    @GetMapping("/service")
    public String servicePage(){
        return "Welcome to Service Page ";
    }
}
