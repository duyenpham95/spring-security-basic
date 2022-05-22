package com.example.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/secured").authenticated()
                .antMatchers("/not-secured").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic(withDefaults());

        /*Permit all */
        /*
        http
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic(withDefaults());
        */

        /*Deny all, 403 returns even with username and password */
        /*
        http
                .authorizeHttpRequests()
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .and()
                .httpBasic(withDefaults());*/
        return http.build();
    }

}