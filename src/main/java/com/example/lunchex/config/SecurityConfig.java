package com.example.lunchex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/home", "/css/**", "/js/**", "/login", "/index").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/dashboard", true)
//                .failureUrl("/login?error=true")
//                .permitAll()
//            )
//            .logout((logout) -> logout
//                .logoutSuccessUrl("/login?logout=true")
//                .permitAll()
//            );
//
//        return http.build();
//    }

}
