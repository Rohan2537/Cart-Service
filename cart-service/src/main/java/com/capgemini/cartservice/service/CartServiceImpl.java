package com.capgemini.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	/**
	 * This method returns all the carts present in the database.
	 */
	@Override
	public List<Cart> getallcarts() {
		cartRepository.findAll().toString();
		return cartRepository.findAll();
	}

	/**
	 * This method returns cart based on it's Id.
	 */
	@Override
	public Cart getcartById(int cartid) {
		Cart cart = cartRepository.findById(cartid).get();
		return cart;
	}

	/**
	 * This method returns the total cart value.
	 */
	@Override
	public double cartTotal(Cart cart) {
		double totalPrice = 0.0;
		double cartPrice = 0.0;
		int count = 0;
		for (Items items : cart.getItems()) {
			System.out.println(++count + " ");
			System.out.println("      ");
			System.out.println(items);
			System.out.println("Product total is: " + items.getPrice() * items.getQuantity());
			totalPrice += items.getPrice() * items.getQuantity();
		}
		cartPrice = cartPrice + totalPrice;
		System.out.println("Total Cart Value is: " + cartPrice);
		return cartPrice;
	}

	/**
	 * This method adds cart in the database.
	 */
	@Override
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);

	}

	@Override
	public Cart updateCart(Cart cart) {
		cart.setTotalPrice(cartTotal(cart));
		cartRepository.save(cart);
		return cart;
	}


}
