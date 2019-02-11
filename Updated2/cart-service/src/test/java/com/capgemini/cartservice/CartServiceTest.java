
package com.capgemini.cartservice;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.cartservice.cartresource.CartResource;
import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.service.CartService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class CartServiceTest {

	@Autowired
	private CartService cartService;

	private Items item;
	private Set<Items> items;

	@Before
	public void setUp() {
		item = new Items("Samsung-Galaxy", 5000, 2);
		items = new HashSet<Items>();
		items.add(item);
	}

	@Test
	public void testGetCart() throws Exception {
		Cart actual = cartService.getcartById(101);
		Cart expected = new Cart(101, items);
		assertEquals(expected.getItems(), actual.getItems());

	}

	@Test(expected = NoSuchElementException.class)
	public void testCartNotFound() throws Exception {
		Cart cart = cartService.getcartById(120);
	}

	@Test
	public void testUpdateCart() throws Exception {
		
		Items item = new Items("Samsung-Galaxy", 5000, 3);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item);
		CartResource cartResource = new CartResource();
		Cart actual = cartService.getcartById(103);
		Cart expected = new Cart(103, itemsSet);
		assertEquals(expected.getItems(), actual.getItems());
	}

}
