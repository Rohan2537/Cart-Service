package com.capgemini.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cartservice.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>  {
	
	public Cart findByCartId(int cartid); 	
	
}
