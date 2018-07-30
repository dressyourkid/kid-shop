package ru.dressyourkid.kidshop.configuration.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Security configuration for app
 */
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("test_customer").password("{noop}cust101").roles("USER");
//        auth.inMemoryAuthentication().withUser("test_moderator").password("{noop}moder9766").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("USER");
//    }

}
