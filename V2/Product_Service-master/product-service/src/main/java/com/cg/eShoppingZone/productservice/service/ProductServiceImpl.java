package com.cg.eShoppingZone.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eShoppingZone.productservice.entity.Product;
import com.cg.eShoppingZone.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProducts(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		System.out.println(productRepository.findAll());
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int productId) {

		Optional<Product> findById = productRepository.findById(productId);
		return findById;
	}

	@Override
	public Optional<Product> getProductByName(String productName) {

		Optional<Product> findByName = productRepository.findByProductName(productName);

		return findByName;
	}

	@Override
	public Product updateProducts(Product product) {
		return productRepository.save(product);

	}

	@Override
	public void deleteProductById(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> productCategory = productRepository.findByCategory(category);
		return productCategory;
	}

	@Override
	public List<Product> getProductByType(String productType) {
		List<Product> product = productRepository.findByProductType(productType);
		return product;
	}

}
