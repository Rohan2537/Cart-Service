
package com.cg.order.orderservice;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.resource.OrderResource;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderServiceApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test

	public void getAllOrdersSuccessTest() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/orders", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

	}
	@Test

	public void getAllOrdersFailureTest() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/order", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);

	}
	@Test
	
	public void getByIdSuccessTest() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/orders/1", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

	}
	@Test
	
	public void getByIdFailureTest() throws Exception {

		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/orders/109", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	

	@Test

	public void placeOrderSuccessTest() throws Exception {
		Orders orders = new Orders(101, null, 121, 400, "card", "gone", 2, null, null);
		ResponseEntity<OrderResource> responseEntity = testRestTemplate.postForEntity("/orders", orders,
				OrderResource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	
	public void placeOrderFailureTest() throws Exception {
		Orders orders = new Orders(101, null, 121, 400, "card", "gone", 2, null, null);
		ResponseEntity<OrderResource> responseEntity = testRestTemplate.postForEntity("/order", orders,
				OrderResource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test

	public void deleteOrderSuccessTest() throws Exception {
		testRestTemplate.delete("/orders/2");
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/orders/2", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	
	public void deleteOrderFailureTest() throws Exception {
		testRestTemplate.delete("/orders/109");
		ResponseEntity<OrderResource> responseEntity = testRestTemplate.getForEntity("/orders/109",
				OrderResource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	
	public void updateExistingOrderTest() throws Exception {

		testRestTemplate.put("/orders/3?orderStatus=willcome", null);
		ResponseEntity<OrderResource> responseEntity = testRestTemplate.getForEntity("/orders/3",
				OrderResource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test

	public void updateNotExistingOrderTest() throws Exception {

		testRestTemplate.put("/orders/120?orderStatus=willcome", null);
		ResponseEntity<OrderResource> responseEntity = testRestTemplate.getForEntity("/orders/120",
				OrderResource.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
