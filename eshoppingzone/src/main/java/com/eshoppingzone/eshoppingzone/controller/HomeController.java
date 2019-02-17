package com.eshoppingzone.eshoppingzone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.eshoppingzone.eshoppingzone.pojo.Address;
import com.eshoppingzone.eshoppingzone.pojo.Cart;
import com.eshoppingzone.eshoppingzone.pojo.Items;
import com.eshoppingzone.eshoppingzone.pojo.Product;

@Controller
public class HomeController {
	
	private static Address staticAddress = new Address();

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/home")
	public String retutnToHome() {
		return "home";
	}
	
	@RequestMapping("/signin")
	public String login() {
		return "login";
	}

	@RequestMapping("/searchproduct")
	public String searchProduct(@RequestParam("search") String search, Model model) {
		Product entity = restTemplate.getForObject("http://localhost:8989/products/productname/" + search,
				Product.class);
		return "index";
	}

	@RequestMapping("/getProductsByCategory")
	public ModelAndView electronicsCategory(@RequestParam("category") String category) {
		List productsList = restTemplate.getForObject("http://localhost:8989/products/category/" + category,
				List.class);
		return new ModelAndView("ProductsByCategory", "product", productsList);
	}

	@RequestMapping("/shoppingcart")
	public ModelAndView shoppingCart() {
		Cart cart = restTemplate.getForObject("http://localhost:9091/carts/11", Cart.class);
		return new ModelAndView("cart", "cart", cart);
	}

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("quantity") int quantity, @RequestParam("productId") int productId) {
		boolean isItemPresent = false;
		/*
		 * System.out.println("Product Id is" +productId[0]);
		 * System.out.println("Product Id is" +productId[1]);
		 */
		Product product = restTemplate.getForObject("http://localhost:8989/products/" + productId, Product.class);
		String productName = product.getProductName();
		double productPrice = product.getPrice();
		Items items = new Items();
		items.setProductName(productName);
		items.setPrice(productPrice);
		items.setQuantity(quantity);

		Cart cart = restTemplate.getForObject("http://localhost:9091/carts/11", Cart.class);
		List<Items> itemsInCart = cart.getItems();

		if (itemsInCart == null)
			itemsInCart = new ArrayList<>();

		for (Items item : itemsInCart) {
			if (item.getProductName().equalsIgnoreCase(productName)) {
				item.setQuantity(quantity + item.getQuantity());
				cart.setTotalPrice(cart.getTotalPrice() + (productPrice * quantity));
				isItemPresent = true;
				break;
			}
		}
		if (isItemPresent == false) {
			itemsInCart.add(items);
			cart.setTotalPrice(cart.getTotalPrice() + (productPrice * quantity));
		}

		cart.setItems(itemsInCart);
		restTemplate.put("http://localhost:9091/carts", cart);
		// restTemplate.postForEntity("http://10.246.92.126:9090/orders", cart, null);

		return new ModelAndView("cart", "cart", cart);
	}

	@RequestMapping("/remove")
	public ModelAndView removeProduct(@RequestParam("quantity") int quantity,
			@RequestParam("productName") String productName) {
		System.out.println("ProductName is : " + productName);
		System.out.println("Quantity is : " + quantity);
		Cart cart = restTemplate.getForObject("http://localhost:9091/carts/11", Cart.class);
		List<Items> itemsInCart = cart.getItems();
		System.out.println("Items present now" + itemsInCart);
		for (Items item : itemsInCart) {
			if (item.getProductName().equals(productName)) {
				System.out.println("Match Found !!!");
				itemsInCart.remove(item);
				System.out.println("Items present after removing" + itemsInCart);
				break;
			}
		}
		restTemplate.put("http://localhost:9091/carts", cart);
		return new ModelAndView("cart", "cart", cart);
	}

	@RequestMapping("/removeProduct")
	public String addressForm(@RequestParam("productName") String[] productName,
			@RequestParam("quantity") int[] quantity, @RequestParam("price") double[] price) {
		for (int i = 0; i < productName.length; i++) {
			System.out.println("Products" + productName[i]);
		}

		List<Items> newList = new ArrayList<Items>();

		for (int i = 0; i < productName.length; i++) {
			Items item = new Items();
			item.setProductName(productName[i]);
			item.setPrice(price[i]);
			item.setQuantity(quantity[i]);
			System.out.println("qty" + quantity[i] + "Price" + price[i] + "Products" + productName[i]);
			newList.add(item);
		}

		System.out.println("NewList" + newList);
		Cart emptyCart = new Cart();
		restTemplate.postForObject("http://localhost:9091/carts/11", emptyCart, Cart.class);
		Cart cart = restTemplate.getForObject("http://localhost:9091/carts/11", Cart.class);
		cart.setItems(newList);
		restTemplate.put("http://localhost:9091/carts", cart);
		return "address";
	}

	@RequestMapping("/address")
	public ModelAndView checkout(@ModelAttribute Address address) {
	return new ModelAndView("placeorder");
	}
}
