package com.cg.order.orderservice.orders.service;

import java.util.List;
import java.util.Optional;


import com.cg.order.orderservice.orders.Orders;

public interface OrderService {

	List<Orders> getAllOrders();

	void placeOrder(Orders newOrder);


	//void changeStatus(Orders orders);
	
	String changeStatus(String orderStatus, int orderId);

	void deleteOrder(int orderId);

	Optional<Orders> getOrderById(int orderId);


	




}