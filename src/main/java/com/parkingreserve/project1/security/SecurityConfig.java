package com.parkingreserve.project1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import com.parkingreserve.project1.services.UserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        @Autowired
        private final UserService userService;

            return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm
                        .loginPage("/login")
                        .permitAll();
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/", "/landing", "/signup", "/css/**", "/js/**", "/assets/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
        }

}
