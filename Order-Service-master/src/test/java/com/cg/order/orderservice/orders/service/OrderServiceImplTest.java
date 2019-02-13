package com.cg.order.orderservice.orders.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.orders.address.Address;
import com.cg.order.orderservice.orders.product.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderServiceImplTest {
	
	@Autowired
	OrderService orderService;

	@Test

	
	public void getAllOrderstest() {
		
		List<Orders> orders=orderService.getAllOrders();
		assertEquals(false, orders.isEmpty());
	}


	@Test
	
	public void allOrdersSizetest() {
		
		List<Orders> orders=orderService.getAllOrders();
		assertEquals(4, orders.size());
	}
	@Test
	public void chaneStatusTest() {
	
		
	String status=orderService.changeStatus("come", 1);
	
	assertEquals("come", status);
		 
		 
	}
	@Test
	public void getByIDPresentTest() {
	
		
		Optional<Orders> orders=orderService.getOrderById(2);
	
		assertEquals(true, orders.isPresent());
		 
		 
	}
	@Test
	public void getByIDNotPresentTest() {
	
		
		Optional<Orders> orders=orderService.getOrderById(120);
	
		assertEquals(false, orders.isPresent());
		 
		 
	}
	@Test

	public void placeOrderTest() {
		
	
		Orders orders = new Orders(LocalDateTime.now(), 343, 600, "cash","arive soon", 1,new Address("hima", 232323, 17, "noida", 788099, "UP"),new Product("bottle", 123));
		orderService.placeOrder(orders);
		Optional<Orders> orderId=orderService.getOrderById(4);
		assertEquals(true, orderId.isPresent());
		 
	}
	/*
	 * @Test public void placeOrderFailTest() {
	 * 
	 * 
	 * Orders orders = new Orders(LocalDateTime.now(), 343, 600,
	 * "cash","arive soon", 1,new Address("hima", 232323, 17, "noida", 788099,
	 * "UP"),new Product("bottle", 123)); orderService.placeOrder(orders);
	 * Optional<Orders> orderId=orderService.getOrderById(000); assertEquals(false,
	 * orderId.isPresent());
	 * 
	 * }
	 * 
	 * @Test public void placeOrderFailureTest() {
	 * 
	 * 
	 * Orders orders = new Orders(-11, LocalDateTime.now(), 343, 600,
	 * "cash","arive soon", 1,new Address("hima", 232323, 17, "noida", 788099,
	 * "UP"),new Product("bottle", 123)); orderService.placeOrder(orders);
	 * Optional<Orders> orderId=orderService.getOrderById(-11); assertEquals(false,
	 * orderId.isPresent());
	 * 
	 * }
	 */
}
