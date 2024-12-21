package com.bakheet.mvc.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;


@Data
@NoArgsConstructor
public class Checkout {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String country;
    private String state;
    private String zip;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;

    public Checkout(String firstName, String lastName, String username, String email, String address, String phone, String country, String state, String zip, String paymentMethod, String cardName, String cardNumber, String cardExpiry, String cardCVV) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.paymentMethod = paymentMethod;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }
}
