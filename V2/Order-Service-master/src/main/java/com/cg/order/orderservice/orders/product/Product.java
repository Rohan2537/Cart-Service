package com.cg.order.orderservice.orders.product;

public class Product {
	private String productId;
	private Integer productName;

	public Product() {
		super();

	}

	public Product(String productId, Integer productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getProductName() {
		return productName;
	}

	public void setProductName(Integer productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + "]";
	}

}
