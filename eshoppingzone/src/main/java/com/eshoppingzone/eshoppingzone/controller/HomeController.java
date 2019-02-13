package com.eshoppingzone.eshoppingzone.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.eshoppingzone.eshoppingzone.pojo.Cart;
import com.eshoppingzone.eshoppingzone.pojo.Items;
import com.eshoppingzone.eshoppingzone.pojo.Product;

@Controller
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {
		return "index";
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
		restTemplate.put("http://localhost:9091/carts/11", cart);
		//restTemplate.postForEntity("http://10.246.92.126:9090/orders", cart, null);

		return new ModelAndView("cartDetails", "cart", cart);
	}

	@RequestMapping("/removeProduct")
	public ModelAndView removeProduct(@RequestParam("quantity") int quantity,
			@RequestParam("productName") String productName) {
		//String[] pname = productName;
		System.out.println("quantity:" + quantity + "name:" + productName);
		
//restTemplate.getForObject(url, responseType)
		return null;
	}

}
