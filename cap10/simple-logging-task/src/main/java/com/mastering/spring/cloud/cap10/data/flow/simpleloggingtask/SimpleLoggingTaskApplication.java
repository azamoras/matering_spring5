package com.mastering.spring.cloud.cap10.data.flow.simpleloggingtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SimpleLoggingTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoggingTaskApplication.class, args);
	}

	@Bean
	public  CommandLineRunner  commandLineRunner()  {
		return  strings  -> System.out.println(    "Task  execution  :" 
				+  new  SimpleDateFormat().format(new  Date()));    
	}
}
