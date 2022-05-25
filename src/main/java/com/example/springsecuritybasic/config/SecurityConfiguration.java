package com.example.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    /**
     * In-Memory Authentication
     * In previous spring security version use AuthenticationManagerBuilder.inMemoryAuthentication
     * <p>
     * In this 5.7.1 version
     * Spring Security’s InMemoryUserDetailsManager implements UserDetailsService
     * to provide support for username/password based authentication that is stored in memory
     * <p>
     * NOTICE Since we use in-memory Authentication
     * the username & password in application.properties not work anymore
     *
     * @return UserDetailsService
     */
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}