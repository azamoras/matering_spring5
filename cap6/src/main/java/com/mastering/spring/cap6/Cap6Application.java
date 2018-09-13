package com.mastering.spring.cap6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableAuthorizationServer
@EnableCaching
@SpringBootApplication
public class Cap6Application {

	public static void main(String[] args) {
	    ApplicationContext  ctx = 	SpringApplication.run(Cap6Application.class, args);
		

	}
}
