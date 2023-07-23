package com.udemy.springboot.myfirstwebapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {


    //LDAP or Database
    //In memory
    @Bean
    public InMemoryUserDetailsManager createUserDetailManager() {
        UserDetails userDetails1 = getNewUser("in28minutes", "1234");
        UserDetails userDetails2 = getNewUser("bill", "1234");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails getNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input
                -> passwordEncoder().encode(input);

        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //All url are protected
    //A login form is shown for unauthorized requests
    //CSRF(Cross-site request forgery) disable
    //Frames in HTML

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //All url are protected
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        //A login form is shown for unauthorized requests
        httpSecurity.formLogin(Customizer.withDefaults());
        //CSRF(Cross-site request forgery) disable
        httpSecurity.csrf().disable();
        //Frames in HTML
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }
}
