package com.mastering.spring.cloud.cap9.microservicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.MetricResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.EurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}
	
	@Autowired
	private EurekaClient eurekaClient;
	  
	
	  
	@Autowired
	private ZipkinProperties zipkinProperties;
	
	@Value("${spring.sleuth.web.skipPattern}")
	private String skipPattern;
	
	
	
}
