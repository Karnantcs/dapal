package com.hms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LoginController {
	
	@Autowired Application application;
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="logMeInFallback")
	@RequestMapping("/login")
	public String logMeIn() {
		System.out.println(" Application Id :"+ application.getApplicationId());
		int count = restTemplate.getForObject("http://inventory/count", Integer.class);
		return count+"";
	}
	
	public String logMeInFallback() {
		
		return "Random Int service is down";
	}
}
