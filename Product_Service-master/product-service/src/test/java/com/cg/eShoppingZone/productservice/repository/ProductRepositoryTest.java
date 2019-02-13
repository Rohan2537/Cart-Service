package com.cg.eShoppingZone.productservice.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.eShoppingZone.productservice.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testForFindAllProducts() {
		List<Product> products = productRepository.findAll();
		//System.out.println(products.get(0));
		assertFalse(products.isEmpty());
	}

	@Test
	public void testForFindProductByAvailableId() {
		Optional<Product> product = productRepository.findById(101);
		assertEquals(101, product.get().getProductId());
		assertThat(product.get().getProductId()).isEqualTo(101);
	}

	@Test
	public void testForFindProductByNotAvailableId() {
		Optional<Product> product = productRepository.findById(18);
		assertFalse(product.isPresent());
	}

}
