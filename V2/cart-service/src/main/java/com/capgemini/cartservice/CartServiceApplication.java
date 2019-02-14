package com.capgemini.cartservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.repository.CartRepository;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);

	}

	/*
	 * @Bean public CommandLineRunner populateData(CartRepository repository) {
	 * Items item = new Items("Nokia", 2000,2); Set<Items> items = new HashSet();
	 * items.add(item);
	 * 
	 * return (arg) -> { repository.save(new Cart(100,items));
	 * 
	 * }; }
	 */
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
