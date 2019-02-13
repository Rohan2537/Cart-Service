package com.cg.eShoppingZone.productservice.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

public class ProductTest {

	@Test
	public void testProduct() {
		Map<Integer, Double> rating = new HashMap<Integer, Double>();
		rating.put(1, 10.00);
		Map<Integer, String> review = new HashMap<Integer, String>();
		review.put(1, "Excellent");
		List<String> image = new ArrayList<String>();
		image.add("imageOne");
		Map<String, String> specification = new HashMap<String, String>();
		specification.put("SpectOne", "two compartments");
		Product product = new Product(101,"handbag","capresee","bags and Luggage",rating,review,image,1400.00,"good product",specification);
		assertEquals(product.getProductId(), 101);
		assertThat(product.getProductId(),Matchers.equalTo(101));
		assertEquals(product.getProductName(), "handbag");
	}

}
