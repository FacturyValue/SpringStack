package com.springboot.java.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.springboot.java.config.MyCustomDsl.customDsl;

/**
 * 1.Code in `Config`s configure method is invoked
 *
 * 2.Code in `MyCustomDsl`s init method is invoked
 *
 * 3.Code in `MyCustomDsl`s configure method is invoked
 */
//@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .apply(customDsl())
                .flag(true)
                .and();
    }
}
