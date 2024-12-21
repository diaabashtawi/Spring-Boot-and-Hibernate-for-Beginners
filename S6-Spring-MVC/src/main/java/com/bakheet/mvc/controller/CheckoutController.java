package com.bakheet.mvc.controller;


import com.bakheet.mvc.domain.Checkout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Arrays;
import java.util.List;

@Controller
public class CheckoutController {


    @GetMapping("/checkout")
    public String checkoutForm(Model model){
        Checkout checkout = new Checkout();
        model.addAttribute("checkout", checkout);
        List<String> countries = Arrays.asList(
                "UAE",
                "Jordan",
                "KSA",
                "Oman"
        );
        List<String> states = Arrays.asList(
                "Dubai",
                "Amman",
                "Riyadh",
                "Muscat"
        );
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        return "checkoutForm";
    }

    @PostMapping("/checkout/process")
    public String submitCheckout(Model model, @ModelAttribute("checkout")Checkout checkout){
        model.addAttribute("checkout", checkout);
        System.out.println(checkout.toString());
        return "checkout-success";

    }



}
