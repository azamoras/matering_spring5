package com.mastering.spring.cloud.cap9.serviceconsumer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mastering.spring.cloud.cap9.serviceconsumer.proxies.RandomServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class NumberAdderController {

	private Log log = LogFactory.getLog(getClass());

	@Value("${number.service.url}")
	private String numberServiceUrl;
	
	@Autowired
	private RandomServiceProxy randomServiceProxy;

	@GetMapping
	@HystrixCommand(fallbackMethod = "getDefaultResponse")
	public long add() {
		long sum = 0;

		List<Integer> numbers = randomServiceProxy.getRandomNumbers();

		for (int number : numbers) {
			sum += number;
		}

		log.warn("Resturning " + sum);
		return sum ;
	}
	
	public long getDefaultResponse() {
		return 1000L;

	}
}
