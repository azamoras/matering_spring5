package com.mastering.spring.cap7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/**","/browser/**", "/actuator/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .oauth2Login().permitAll();
        
    
    }
	
	 @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/browser/**", "/actuator/**"); // #3
	  }
	  
	
	    @Bean
	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	    	
	    	return super.authenticationManager();
	    }
	
	
}