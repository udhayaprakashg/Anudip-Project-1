package com.delivery.service;

import java.util.List;

import com.delivery.model.Cart;

public interface CartService {
	
	List<Cart> findAllCart();
	
	Cart saveCart(Cart cart);
	
	Cart findCartById(Long id);
	
	Cart updateCartById(Long id, Cart cart);
	
	void deleteCartById(Long id);
	

}
