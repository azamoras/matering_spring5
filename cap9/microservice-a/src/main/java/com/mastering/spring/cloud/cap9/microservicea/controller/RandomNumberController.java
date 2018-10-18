package com.mastering.spring.cloud.cap9.microservicea.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RandomNumberController {

	private Log log = LogFactory.getLog(RandomNumberController.class);


	@GetMapping("/random")
	@HystrixCommand(fallbackMethod = "getDefaultResponse")
	public  List<Integer> random() {
		List<Integer>  numbers  =  new  ArrayList<Integer>();
		for  (int  i  =  1;  i  <=  5;  i++)  {          
			numbers.add(generateRandomNumber());        
		}              
		log.warn("Returning "  +  numbers);   
		return  numbers;

	}
	private  int  generateRandomNumber()  {      

		return  (int) (Math.random() *  1000);    

	}
	
	public List<Integer> getDefaultResponse() {
		List<Integer> list = new ArrayList<>();
		list.add(1111); 
		return list;
		

	}

}
