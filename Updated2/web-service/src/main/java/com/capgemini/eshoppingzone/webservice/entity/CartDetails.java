package com.capgemini.eshoppingzone.webservice.entity;

public class CartDetails {

	private Cart cart;
	private Items items;
	
	public CartDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDetails(Cart cart, Items items) {
		super();
		this.cart = cart;
		this.items = items;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "CartDetails [cart=" + cart + ", items=" + items + "]";
	}
	
	
}
