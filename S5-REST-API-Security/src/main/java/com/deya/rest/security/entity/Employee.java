package com.deya.rest.security.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "first_name"
    )
    private String firstName;
    @Column(
            name = "last_name"
    )
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
