package com.cg.order.orderservice.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.orders.repository.OrderRepository;


@Service
public class OderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;


	@Override
	public List<Orders> getAllOrders() {

		return orderRepository.findAll();

	}

	@Override
	public void placeOrder(Orders newOrder) {

		if(newOrder.getOrderId()>0)
			orderRepository.save(newOrder);
	}

	/*
	 * @Override public void changeStatus(Orders orders) {
	 * 
	 * orderRepository.save(orders);
	 * 
	 * }
	 */

	
	@Override
	public Optional<Orders> getOrderById(int orderId) {
	
		return orderRepository.findById(orderId);
	}

	/*
	 * Optional<Orders> optional = orderService.getAccountById(orderId); Orders
	 * orders = optional.get(); orders.setOrderStatus(orderStatus);
	 */
	@Override
	public String changeStatus(@RequestParam String orderStatus,@PathVariable int orderId) {
		Orders order = orderRepository.findById(orderId).get();
		order.setOrderStatus(orderStatus);
		orderRepository.save(order);
		return orderStatus;
		
		
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
		
	}

	

}
