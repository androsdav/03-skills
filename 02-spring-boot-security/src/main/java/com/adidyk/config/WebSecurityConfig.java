package com.adidyk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 /** Class WebSecurityConfig used for adds users (role user or admin) and configures http security.
  *  @author Didyk Andrey (androsdav@gmail.com).
  *  @since 20.02.2020.
  *  @version 1.0.
  */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     /**
      * configure - configures http security/
      * @param http - link variable to object of class HttpSecurity.
      * @throws Exception - exception.
      */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/index", "/home", "/css/**", "/js/**", "/images/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

     /**
      * configureGlobal - used for added users and sets role for users.
      * @param auth - link variable to object of class AuthenticationManagerBuilder.
      * @throws Exception - exception.
      */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("123")).roles("USER");
    }

     /**
      * passwordEncoder - password encoder.
      * @return - new object of class BCryptPasswordEncoder.
      */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}