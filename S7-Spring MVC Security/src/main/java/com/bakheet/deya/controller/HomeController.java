package com.bakheet.deya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/leaders")
    public String leaderMeeting(){
        return "leaderMeeting";
    }

    @GetMapping("/systems")
    public String adminMeeting(){
        return "adminMeeting";
    }
}
