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

import com.delivery.model.Customer;
import com.delivery.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/add")
	public String addCustomer(@RequestBody Customer customer) {
	    customerService.addCustomer(customer);
	    return "Your Order was Added Successfully";
	}
	
	
	@GetMapping("/getAll")
	public List<Customer> getAllCart() {
		return customerService.findAllCustomer();
	}
	
	//Additional one
	@GetMapping("/get/{id}")
	public Customer getById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable("id") Long id, Customer customer ) {
		customerService.updateCustomerById(id, customer);
		return "Your Data was Updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		customerService.deleteCustomerById(id);
		return "Your Data was Deleted!";
	}
}

