package com.adidyk.config;

import com.adidyk.service.UserService;
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
  *  @since 02.02.2020.
  *  @version 1.0.
  */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     /**
      * @param userService - user service.
      */
    private UserService userService;

     /**
      * WebSecurityConfig - constructor.
      * @param userService - user service.
      */
     @Autowired
     public WebSecurityConfig(UserService userService) {
         this.userService = userService;
     }

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
                    // access is allowed to all users
                    .antMatchers("/", "/index", "/home", "/css/**", "/js/**", "/images/**", "/public/**").permitAll()
                    // access is allowed only not registration users
                    .antMatchers("/registration").not().fullyAuthenticated()
                    // access is allowed only admin
                    .antMatchers("/admin").hasRole("ADMIN")
                    // access is allowed only user
                    .antMatchers("/user").hasRole("USER")
                    // all other pages require authentication
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }

     /**
      * configureGlobal - used for added users and sets role for users.
      * @param auth - link variable to object of class AuthenticationManagerBuilder.
      * @throws Exception - exception.
      */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder());
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