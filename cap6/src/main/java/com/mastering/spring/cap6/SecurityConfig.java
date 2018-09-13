package com.mastering.spring.cap6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
         .anyRequest().authenticated().antMatchers("/oauth/**").permitAll()
         .and()
         .oauth2Login();
    }
	
	  
	
	    @Bean
	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	    	
	    	return super.authenticationManager();
	    }
	
	
}