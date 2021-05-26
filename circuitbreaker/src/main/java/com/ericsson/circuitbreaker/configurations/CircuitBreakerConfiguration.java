package com.ericsson.circuitbreaker.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CircuitBreakerConfiguration {

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
