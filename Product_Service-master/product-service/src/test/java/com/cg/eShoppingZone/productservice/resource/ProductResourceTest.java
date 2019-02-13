
package com.cg.eShoppingZone.productservice.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.eShoppingZone.productservice.entity.Product;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	/*
	 * @Test public void testForGetAllProducts() { ResponseEntity<ProductResource>
	 * responseEntity = testRestTemplate.getForEntity("/products",
	 * ProductResource.class); assertEquals(); }
	 */

	@Test
	public void testForGetProductByIdForAvailableProductId() {
		ResponseEntity<ProductResource> responseEntity = testRestTemplate.getForEntity("/products/151",
				ProductResource.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void testForGetProductByIdForNotAvailableProductId() throws Exception {
		ResponseEntity<ProductResource> responseEntity = testRestTemplate.getForEntity("/products/1212",
				ProductResource.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

	}

	@Test
	public void testForCorrectUrl() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void testForIncorrectUrl() throws Exception {
		ResponseEntity<ProductResource> responseEntity = testRestTemplate.getForEntity("/product/productId/120",
				ProductResource.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void testForBadRequestUrl() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products/productId", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

	}

	@Test
	public void testForMethodNotAllowedOnWrongMapping() {
		Product product = new Product();
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/products/101", product, String.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());

	}

	@Test public void testForUpdateProduct() { 
		  Product product = new Product();
		  testRestTemplate.put("/products",product,String.class );
		  ResponseEntity<ProductResource> responseEntity = testRestTemplate.getForEntity("/products/101",
				ProductResource.class);
		  assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	    }

	@Test
	@Ignore
	public void testForDeleteProductById() {
		testRestTemplate.delete("/products/201");
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products/201", String.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
