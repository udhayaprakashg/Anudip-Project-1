package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.model.Cart;
import com.delivery.repository.CartRepository;
import com.delivery.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public List<Cart> findAllCart() {
		return cartRepository.findAll();
	}

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart findCartById(Long id) { 
		return cartRepository.findById(id).get();
	}

	@Override
	public Cart updateCartById(Long id, Cart cart) {
		Cart exisiting = cartRepository.findById(id).get();
		exisiting.setPdt_quantity(cart.getPdt_quantity());
		exisiting.setPdt_price(cart.getPdt_price());
		return cartRepository.save(exisiting);
	}

	@Override
	public void deleteCartById(Long id) {
		cartRepository.deleteById(id);
	}

}
