package com.capgemini.cartservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.repository.CartRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CartRepositoryTest {

	@Autowired
	private CartRepository cartRepository;
	
	@Test
	public void testGetCartById() throws Exception {
		Cart cart = cartRepository.findById(102).get();
		String expected = "Cart [cartId=102, quantity=1, product=Product [productId=102, productName=iphone, category=Electronics]]";
		String actual= cart.toString();
		assertEquals(expected,actual);
	}
}
