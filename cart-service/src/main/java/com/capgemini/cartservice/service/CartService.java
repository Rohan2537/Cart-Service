package com.capgemini.cartservice.service;

import java.util.List;

import com.capgemini.cartservice.entity.Cart;

public interface CartService {

	public Cart getcartById(int cartid);

	public Cart updateCart(Cart cart);

	public List<Cart> getallcarts();
	
	public double cartTotal(Cart cart);
	
	public Cart addCart(Cart cart);


}