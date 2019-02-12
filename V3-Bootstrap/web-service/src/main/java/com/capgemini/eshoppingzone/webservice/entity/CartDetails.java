package com.capgemini.eshoppingzone.webservice.entity;

import java.util.Arrays;

public class CartDetails {

	private Object[] item;

	public CartDetails() {
	
	}
	
	public CartDetails(Object[] item) {
		super();
		this.item = item;
	}

	public Object[] getItem() {
		return item;
	}

	public void setItem(Object[] item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "CartDetails [item=" + Arrays.toString(item) + "]";
	}
	
	
}
