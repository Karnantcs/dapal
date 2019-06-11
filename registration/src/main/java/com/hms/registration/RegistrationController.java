package com.hms.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableCircuitBreaker
@RestController
public class RegistrationController {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="registerUserFallBack")
	@RequestMapping("/register")
	public String registerUser() {
		String inventory = restTemplate.getForObject("http://inventory/count", String.class);
		return inventory;
	}
	
	public String registerUserFallBack() {
		
		return "service is down";
	}
}
