package com.cg.eShoppingZone.productservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eShoppingZone.productservice.entity.Product;
import com.cg.eShoppingZone.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@PostMapping
	public void addProducts(@RequestBody Product product) {
		productService.addProducts(product);

	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {

		Optional<Product> product = productService.getProductById(productId);
		if (!product.isPresent()) {
			// System.out.println("in get method " + product);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}

	@GetMapping("/type/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String productType) {

		List<Product> product = productService.getProductByType(productType);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/productName/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) {

		Optional<Product> product = productService.getProductByName(productName);
		if (!product.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {

		List<Product> product = productService.getProductByCategory(category);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

		Product updatedProduct = productService.updateProducts(product);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		Optional<Product> product = productService.getProductById(productId);
		productService.deleteProductById(productId);

	}

}
