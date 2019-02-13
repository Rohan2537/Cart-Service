package com.capgemini.cartservice.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
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
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
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
	public Cart addToCart(Cart cart) {
		/*
		 * Cart updateCart = getcartById(cart.getCartId());
		 * System.out.println("1.Cart values are: "+updateCart); Set<Items> items =
		 * updateCart.getItems(); System.out.println("2.Items are: "+items); Set<Items>
		 * newItemsToAdd = cart.getItems(); //Items to add into cart
		 * System.out.println("3.New Items to add are: "+newItemsToAdd);
		 * 
		 * items.addAll(newItemsToAdd);
		 * 
		 * /*Iterator<Items> itr = newItemsToAdd.iterator(); while(itr.hasNext()) {
		 * items.add(itr.next()); } updateCart.setItems(items);
		 */
		/*
		 * Query query = new Query(Criteria.where("cartId").is(cart.getCartId()));
		 * Update update = new Update(); update.unset("items");
		 * mongoTemplate.updateFirst(query, update, Cart.class);
		 */
		cart.setTotalPrice(cartTotal(cart));
		// cartRepository.deleteById(cart.getCartId());
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart removeFromCart(Cart cart) {
		Cart updateCart = getcartById(cart.getCartId());
		List<Items> items = updateCart.getItems(); // Items already in cart
		List<Items> itemsToRemove = cart.getItems(); // Items to remove from the cart
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
