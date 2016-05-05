package com.grapheople.lifeisquest.config;

/**
 * Created by pax on 2016. 5. 4..
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
  }

  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/", "/home").permitAll()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .permitAll()
          .and()
        .logout()
          .permitAll();

  }
}