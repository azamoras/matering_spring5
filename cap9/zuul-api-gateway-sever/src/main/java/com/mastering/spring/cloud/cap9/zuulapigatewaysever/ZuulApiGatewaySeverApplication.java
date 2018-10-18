package com.mastering.spring.cloud.cap9.zuulapigatewaysever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApiGatewaySeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewaySeverApplication.class, args);
	}
}
