package com.bakheet.mvc.controller;

import com.bakheet.mvc.domain.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${gender}")
    private List<String> gender;
    @Value("${systems}")
    private List<String> os;

    /*
     * add and InitBinder to convert trim input Strings
     * remove leading and traling whitespace
     * resolve issue for validation
     * */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/variable-expression")
    public String variableExpression(Model model){
        User user = new User(
                "Deya",
                "Bakheet",
                "diaabashtawi@gmail.com",
                "ADMIN",
                "Male"
        );

        User userSwitch = new User(
                "Bakheet",
                "Bashtawi",
                "bakheet@gmail.com",
                "ADMIN",
                "Male"
        );

        User user1 = new User(
                "User",
                "One",
                "userOne@gmail.com",
                "ADMIN",
                "Male"
        );

        User user2 = new User(
                "User",
                "Two",
                "userTwo@gmail.com",
                "USER",
                "Female"
        );

        User user3 = new User(
                "User",
                "Three",
                "userThree@gmail.com",
                "USER",
                "Male"
        );


        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users", users);
        model.addAttribute("userSwitch", userSwitch);
        model.addAttribute("user", user);
        model.addAttribute("id", 92);

        return "user";
    }


    @GetMapping("/userForm")
    public String userForm(Model model){
        model.addAttribute("countries", countries);
        model.addAttribute("gender", gender);
        model.addAttribute("os", os);
        model.addAttribute("userFormTwo", new User());

        return "userForm";
    }

    @PostMapping("/proccessUserFrom")
    public String proccessUserFrom(@Valid @ModelAttribute("userFormTwo") User userFormTwo, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            System.out.println("errors : " + bindingResult.getAllErrors());
            return "userForm";
        }else {
//            System.out.println("Bindin Result : " + bindingResult.toString());
            return "submit-from";
        }
    }


}
