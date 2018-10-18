package com.mastering.spring.cloud.cap9.zipkindistributedtracingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@SpringBootApplication
@zipkin.server.EnableZipkinServer //version 1
//@EnableEurekaClient
public class ZipkinDistributedTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedTracingServerApplication.class, args);
	}
}
