package com.springboot.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * We can configure multiple HttpSecurity instances just as we can have multiple <http> blocks.
 * The key is to extend the WebSecurityConfigurerAdapter multiple times
 *
 * 1.Configure Authentication as normal
 * 2.Create an instance of WebSecurityConfigurerAdapter that contains @Order to specify which WebSecurityConfigurerAdapter should be considered first.
 *   The http.antMatcher states that this HttpSecurity will only be applicable to URLs that start with /api/
 * 3.Create another instance of WebSecurityConfigurerAdapter.
 * 4.If the URL does not start with /api/ this configuration will be used. This configuration is considered after ApiWebSecurityConfigurationAdapter since it has an @Order value after 1 (no @Order defaults to last).
 */
//@EnableWebSecurity
public class MultiHttpSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
        return manager;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")
                    .authorizeHttpRequests(authorize -> authorize
                            .anyRequest().hasRole("ADMIN")
                    )
                    .httpBasic(withDefaults());
        }
    }

    //@Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(authorize -> authorize
                            .anyRequest().authenticated()
                    )
                    .formLogin(withDefaults());
        }
    }
}