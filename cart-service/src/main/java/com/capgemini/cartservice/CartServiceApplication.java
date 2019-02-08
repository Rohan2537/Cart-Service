package com.capgemini.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);

	}

	/*
	 * @Bean public CommandLineRunner populateData(CartRepository repository) {
	 * return (arg) -> { repository.save(new Cart(100, 1, new Product(100, "Nokia",
	 * "Electronics"))); repository.save(new Cart(101, 1, new Product(101,
	 * "Samsung", "Electronics"))); repository.save(new Cart(102, 1, new
	 * Product(102, "iphone", "Electronics"))); repository.save(new Cart(103, 1, new
	 * Product(103, "Redmi", "Electronics"))); repository.save(new Cart(104, 1, new
	 * Product(104, "Sony", "Electronics"))); }; }
	 */

}
