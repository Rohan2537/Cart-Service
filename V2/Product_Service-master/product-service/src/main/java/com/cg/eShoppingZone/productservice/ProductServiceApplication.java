package com.cg.eShoppingZone.productservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.eShoppingZone.productservice.entity.Product;
import com.cg.eShoppingZone.productservice.repository.ProductRepository;

@SpringBootApplication

public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner addData(ProductRepository productRepository) {
		Map<Integer, Double> rating = new HashMap<Integer, Double>();
		rating.put(1, 10.00);
		Map<Integer, String> review = new HashMap<Integer, String>();
		review.put(1, "Excellent");
		List<String> image = new ArrayList<String>();
		image.add("C:/Users/aambewad/Desktop/Images/101.jpg");
		Map<String, String> specification = new HashMap<String, String>();
		specification.put("SpectOne", "two compartments");
		specification.put("SpectTwo", "Adjustable strap");
		return (arg) -> {
			//productRepository.save(new Product(100,"handbag","bags and Luggage",null,null,null,1400.00,"good product",null));
			productRepository.save(new Product(101, "handbag","capresee", "bags", rating, review, image, 1500.00, "good product",
					specification));
			productRepository.save(new Product(102, "camera","GoPro HERO7 Black Camera", "electronics", rating, review, image, 1500.00, "excellent product",
					specification));
		};

	}

}
