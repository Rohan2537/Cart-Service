package com.capgemini.cartservice.entity;

import java.util.List;
import java.util.Map;

public class Product {
	private int productId;
	private String productName;
	private String category;
	private Map<Integer, Double> rating;
	private Map<Integer, String> review;
	private List<String> image;
	private double price;
	private String description;
	private Map<String, String> specification;

	public Product() {

	}

	public Product(int productId, String productName, String category, Map<Integer, Double> rating,
			Map<Integer, String> review, List<String> image, double price, String description,
			Map<String, String> specification) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<Integer, Double> getRating() {
		return rating;
	}

	public void setRating(Map<Integer, Double> rating) {
		this.rating = rating;
	}

	public Map<Integer, String> getReview() {
		return review;
	}

	public void setReview(Map<Integer, String> review) {
		this.review = review;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", rating=" + rating + ", review=" + review + ", image=" + image + ", price=" + price
				+ ", description=" + description + ", specification=" + specification + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	

}
