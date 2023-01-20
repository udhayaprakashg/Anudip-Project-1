package com.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.model.Cart;
import com.delivery.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
      
	@Autowired
	private CartService cartService;
	
	/* Test Purpose Only
	 * @RequestMapping("/")
	private String test() {
		Customer customer = new Customer("Udhaya","udhya000@gmail.com",(long) 63806944,"CPT");
		Cart cart = new Cart("Pizza",120,23,customer);
		cartService.saveCart(cart);
		return "Tested Successfully";
	}*/
	
	@PostMapping("/add")
	public String addCart(@RequestBody Cart cart) {
	    cartService.saveCart(cart);
	    return "Your Cart Product is Added Successfully";
	}
	
	
	@GetMapping("/getAll")
	public List<Cart> getAllCart() {
		return cartService.findAllCart();
	}
	
	//Additional one
	@GetMapping("/get/{id}")
	public Cart getById(@PathVariable("id") Long id) {
		return cartService.findCartById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable("id") Long id, Cart cart ) {
		cartService.updateCartById(id, cart);
		return "Your Cart Product was Updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		cartService.deleteCartById(id);
		return "Your Cart Product was Deleted!";
	}
}
