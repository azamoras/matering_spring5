package com.mastering.spring.cap8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;


@EnableCaching
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    ApplicationContext  ctx = 	SpringApplication.run(Application.class, args);
		

	}
}
