package com.cg.order.orderservice.resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.orders.address.Address;
import com.cg.order.orderservice.orders.product.Product;
import com.cg.order.orderservice.orders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	private static int orderId =0;
	
	@GetMapping
	public List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public ResponseEntity getOrderById(@PathVariable int orderId) {

		Optional<Orders> order = orderService.getOrderById(orderId);
		if(!order.isPresent())
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping
	public void placeOrder(@RequestBody Orders newOrder) {
		newOrder.setOrderId(orderId++);
	
	
			orderService.placeOrder(newOrder);
	}

	/*
	 * @PutMapping public void changeStatus(@RequestBody Orders orders) {
	 * orderService.changeStatus(orders);
	 * 
	 * }
	 */

	@PutMapping("/{orderId}")
	public void changeOrderStatus(@RequestParam String orderStatus, @PathVariable int orderId) {

		orderService.changeStatus(orderStatus, orderId);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
		Optional<Orders> order = orderService.getOrderById(orderId);
		if(!order.isPresent())
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		orderService.deleteOrder(orderId);
		return new ResponseEntity(HttpStatus.OK);

	}
	
	

}
