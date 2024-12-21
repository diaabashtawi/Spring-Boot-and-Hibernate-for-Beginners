package com.bakheet.mvc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("serverDate", LocalDateTime.now());
        return "home";
    }

    @GetMapping("/showForm")
    public String helloWorld(){
        return "hello-world-form";
    }

    @PostMapping("/upperCase")
    public String convertNameToUpperCase(@RequestParam("name") String name, Model model) {
        name = name.toUpperCase();
        String convertedName = "Your name in Uppercase : " + name;
        model.addAttribute("convertedName", convertedName);
        return "hello-world";
    }



}
