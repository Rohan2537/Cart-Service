package com.cg.eShoppingZone.websiteEshoppingZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebsiteEshoppingZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteEshoppingZoneApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}

