package com.cg.eShoppingZone.productservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.eShoppingZone.productservice.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataMongoTest
public class ProductServiceTest {

	/*
	 * @Autowired private ProductRepository productRepository;
	 */
	@Autowired
	private ProductService productServiceImpl;

	private Product product;

	@Before
	public void setUp() {
		Map<Integer, Double> rating = new HashMap<Integer, Double>();
		rating.put(1, 10.00);
		Map<Integer, String> review = new HashMap<Integer, String>();
		review.put(1, "Excellent");
		List<String> image = new ArrayList<String>();
		image.add("C:/Users/aambewad/Desktop/Images/101.jpg");
		Map<String, String> specification = new HashMap<String, String>();
		specification.put("SpectOne", "two compartments");
		specification.put("SpectTwo", "Adjustable strap");
		product = new Product(101, "handbag","capresee", "bags and Luggage", rating, review, image, 1500.00, "good product",
				specification);
	}

	/*
	 * @Test (expected = ProductNotAddedException.class) public void
	 * addProductTest() throws Exception {
	 * 
	 * productServiceImpl.addProducts(product);
	 * 
	 * }
	 */
	
	@Test
	public void testForGetAllProducts() {
		List<Product> products = productServiceImpl.getAllProducts();
		assertEquals(81, products.size());
	}

	@Test
	public void testForGetProductByIdCheckId() {
		Optional<Product> actualProduct = productServiceImpl.getProductById(101);
		assertEquals(actualProduct.get().getProductId(), 101);

	}

	@Test
	public void testForGetProductByIdCheckProductObject() {
		Optional<Product> actualProduct = productServiceImpl.getProductById(101);
		assertEquals(product, actualProduct.get());

	}

	@Test(expected = NoSuchElementException.class)
	public void testForGetProductByIdProductNotAvailable() {
		Optional<Product> actualProduct = productServiceImpl.getProductById(90);

		assertEquals(product, actualProduct.get());
	}

	@Test
	public void testForGetProductByName() {
		Optional<Product> actualProduct = productServiceImpl.getProductByName("handbag");
		assertEquals(product, actualProduct.get());

	}

	@Test(expected = NoSuchElementException.class)
	public void testForGetProductByNameNotAvailable() {
		Optional<Product> actualProduct = productServiceImpl.getProductByName("shoes");
		assertEquals(product, actualProduct.get());

	}

	@Test
	public void testForUpdateProducts() {
		Product actualProduct = productServiceImpl.getProductById(102).get();
		actualProduct.setPrice(45600.00);
		// actualProduct.setDescription("Excellent product");
		Product updatedProduct = productServiceImpl.updateProducts(actualProduct);
		assertEquals(actualProduct, updatedProduct);
	}

	@Test
	public void testForDeleteProductByIdElementPresent() {

		productServiceImpl.deleteProductById(204);
		Optional<Product> actualProduct = productServiceImpl.getProductById(204);
		assertFalse(actualProduct.isPresent());
	}

}
