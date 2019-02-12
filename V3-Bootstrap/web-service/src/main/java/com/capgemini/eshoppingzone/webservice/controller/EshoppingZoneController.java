package com.capgemini.eshoppingzone.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.eshoppingzone.webservice.entity.Cart;
import com.capgemini.eshoppingzone.webservice.entity.CartDetails;

@Controller
public class EshoppingZoneController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/cartdetails/{cartid}")
	public ModelAndView getCartById(@PathVariable int cartid) {
		Cart updateCart = restTemplate.getForObject("http://localhost:9091/carts/"+cartid,Cart.class);
		System.out.println("cart Details : " +updateCart);
		CartDetails cartDetails = new CartDetails();
		cartDetails.setItem(updateCart.getItems().toArray());
		Object[] item = cartDetails.getItem();
		for (int i = 0; i < item.length; i++) {
			System.out.println(item[i]);	
		}
		//Object[] item = updateCart.getItems().toArray();
		
		return new ModelAndView("index","updateCart",updateCart);
	}
	
	
	
}
