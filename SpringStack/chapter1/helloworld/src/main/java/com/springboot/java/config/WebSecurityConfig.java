package com.springboot.java.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 *
 *  <http>
 * 	    <intercept-url pattern="/**" access="authenticated"/>
 * 	    <form-login />
 * 	    <http-basic />
 * </http>
 */
public class WebSecurityConfig implements WebMvcConfigurer {


    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
    }
}
