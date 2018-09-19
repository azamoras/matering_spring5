package com.mastering.spring.cap7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableCaching
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    ApplicationContext  ctx = 	SpringApplication.run(Application.class, args);
		

	}
}
