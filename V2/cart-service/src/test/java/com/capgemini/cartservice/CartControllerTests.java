
package com.capgemini.cartservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.cartservice.entity.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetCarts() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("/carts", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testGetCartsForPostMethod() throws Exception { 
		Cart cart = new Cart();
		ResponseEntity<String> response = restTemplate.postForEntity("/carts", cart, String.class);
		assertEquals(response.getStatusCode(), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Test
	public void testGetCartById() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("/carts/102", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testCartNotFound() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("/cart/110", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void testCartNotPresentInternalServerError() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("/carts/112", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	public void testGetCartByIdBadRequest() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("/carts/products", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

//	@Test
//	public void testUpdateCart() throws Exception {
//		ResponseEntity<String> response = restTemplate.put("/carts", Cart.class);
//		assertEquals(response.getStatusCode(),HttpStatus.OK);
//	}

}
