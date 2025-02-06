package com.bakheet.deya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage() {
        return "accessDenied";
    }
}
