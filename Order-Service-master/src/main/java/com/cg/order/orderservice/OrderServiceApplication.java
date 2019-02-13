package com.cg.order.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner yourOrders(OrderRepository orderRepository) {
	 * 
	 * return (arg) -> { orderRepository.save(new Orders( LocalDateTime.now(), 305,
	 * 4000, "card", "deliverd", 6, new Address("Hemalatha", 123123, 16, "NLR",
	 * 524004, "AP"), new Product("bag", 343))); orderRepository.save(new
	 * Orders(LocalDateTime.now(), 305, 4000, "card", "deliverd", 6, new
	 * Address("kalyan", 123123, 16, "pune", 524004, "MP"), new Product("bag",
	 * 343)));
	 * 
	 * };
	 * 
	 * }
	 */

}
