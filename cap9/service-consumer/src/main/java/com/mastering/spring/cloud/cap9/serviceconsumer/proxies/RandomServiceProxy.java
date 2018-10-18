package com.mastering.spring.cloud.cap9.serviceconsumer.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zuul-api.gateway")
@RibbonClient(name = "microservice-a")
public interface RandomServiceProxy {

	@RequestMapping(value = "/microservice-a/random", method = RequestMethod.GET)
	public List<Integer> getRandomNumbers();
}
