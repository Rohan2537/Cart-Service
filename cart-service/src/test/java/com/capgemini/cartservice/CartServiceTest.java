
package com.capgemini.cartservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.cartservice.entity.Cart;
import com.capgemini.cartservice.entity.Items;
import com.capgemini.cartservice.entity.Product;
import com.capgemini.cartservice.service.CartService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class CartServiceTest {

	@Autowired
	private CartService cartService;

	private Items item;
	private Set<Items> items;
	
	private Map<Integer,Double> mapOne;
	private Map<Integer,String> mapTwo;
	private Map<String,String> mapThree;
	private List list ;
	

	@Before
	public void setUp() {
		mapOne = new HashMap();
		mapOne.put(null, null);
		
		mapTwo = new HashMap();
		mapTwo.put(null, null);
		
		mapThree = new HashMap();
		mapThree.put(null, null);
		
		list = new ArrayList();
		list.add(null);
		item = new Items( new Product(100,"Nokia","electronics",mapOne,mapTwo,list,2000,null,mapThree),2);
		items = new HashSet<Items>();
		items.add(item);
	}

	@Test
	public void testGetCart() throws Exception {
		Cart actual = cartService.getcartById(100);
		Cart expected = new Cart(100, items);
		assertEquals(expected.getItems(), actual.getItems());

	}

	@Test(expected = NoSuchElementException.class)
	public void testCartNotFound() throws Exception {
		Cart cart = cartService.getcartById(120);
	}

	@Test
	public void testUpdateCart() throws Exception {
		
		Items item = new Items(new Product(100,"Nokia","electronics",mapOne,mapTwo,list,2000,null,mapThree),3);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item);
		Cart actual = cartService.getcartById(101);
		Cart expected = new Cart(101, itemsSet);
		assertEquals(expected.getItems(), actual.getItems());
	}

}
