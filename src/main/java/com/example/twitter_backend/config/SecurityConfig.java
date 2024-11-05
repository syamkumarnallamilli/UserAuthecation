package com.example.twitter_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection for simplicity
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                .requestMatchers("/api/auth/register").permitAll() // Allow public access to register endpoint
                .requestMatchers("/api/auth/login").permitAll() // Allow public access to login endpoint
                .anyRequest().authenticated() // Require authentication for all other endpoints
            )
            .headers(headers -> headers.frameOptions().sameOrigin()); // Allow frames for H2 console

        return http.build();
    }
}
