package com.bakheet.mvc.domain;


import com.bakheet.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "is required")
    @Size(min = 3, max = 50, message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 3, max = 50, message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    private String email;
    private String role;
    private String gender;
    private String country;
    private List<String> os;
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero ")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String postalCode;
    @CourseCode
    private String countryCode;

    public User(String firstName, String lastName, String email, String role, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.gender = gender;
    }
}
