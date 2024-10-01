package com.deya.springcore.config;


import com.deya.springcore.common.Coach;
import com.deya.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swim")
    public Coach getSwimCoach(){
        return new SwimCoach();
    }
}

