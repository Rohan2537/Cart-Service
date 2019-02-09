package com.capgemini.cartservice.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.entity.Product;
import com.capgemini.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	// double totalPrice;
	// double cartPrice;

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
	 * This method returns the updated cart, after addition or deletion of any
	 * product from the cart.
	 */
	@Override
	public Cart addToCart(Cart cart) {
		Cart updateCart = getcartById(cart.getCartId());
		Set<Items> items = updateCart.getItems();					//Items present in cart	
		Set<Items> newItemsToAdd = cart.getItems();						//Items to add into cart		
		Iterator<Items> itr = newItemsToAdd.iterator();
		while(itr.hasNext())
		{
			items.add(itr.next());
		}
		updateCart.setItems(items);
		updateCart.setTotalPrice(cartTotal(updateCart));
		cartRepository.save(updateCart);
		return updateCart;
	}

	/**
	 * This method delete's the cart based on it's Id.
	 */
	@Override
	public void deleteCart(int cartid) {
		cartRepository.deleteById(cartid);

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
			Product products = items.getProduct();
			System.out.println(items.toString());
			System.out.println("Product total is: " + products.getPrice() * items.getQuantity());
			totalPrice += products.getPrice() * items.getQuantity();

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
	public Cart removeFromCart(Cart cart) {
		Cart updateCart = getcartById(cart.getCartId());
		Set<Items> items = updateCart.getItems();					 // Items already in cart
		Set<Items> itemsToRemove = cart.getItems(); 					// Items to remove from the cart
		Iterator<Items> itr = itemsToRemove.iterator();
		while (itr.hasNext()) {
			items.remove(itr.next());
		}
		updateCart.setItems(items);
		updateCart.setTotalPrice(cartTotal(updateCart));
		cartRepository.save(updateCart);
		return updateCart;
	}

}
