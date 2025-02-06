package com.bakheet.deya.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {



    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        /*
        * This is using custom table for login
        *  Nothing matchs with the default Spring Security table schema
        * */
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // Apply security to all routes
                .authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .requestMatchers(
                                        "/resources/static/**",
                                        "/css/**",
                                        "/js/**",
                                        "/vendor/**",
                                        "/img/**",
                                        "/scss/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()

                ).formLogin(
                        formLogin -> formLogin.loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticatedUser")
                                .permitAll()
                ).logout(
                        logout -> logout.permitAll()
                ).exceptionHandling(exception -> exception.accessDeniedPage("/accessDenied"));
        return http.build();
    }


   /* Im Memory User Details
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails deya = User.builder()
                .username("deya")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(deya, john, mary, susan);
    }
    */

}
