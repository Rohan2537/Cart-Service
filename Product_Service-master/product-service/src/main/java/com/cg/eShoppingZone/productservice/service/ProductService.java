package com.cg.eShoppingZone.productservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.eShoppingZone.productservice.entity.Product;

public interface ProductService {

	void addProducts(Product product);

	List<Product> getAllProducts();

	Optional<Product> getProductById(int productId);

	Optional<Product> getProductByName(String productName);
	
	Product updateProducts(Product product);
	
	void deleteProductById(int productId);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByType(String productType);
	

}