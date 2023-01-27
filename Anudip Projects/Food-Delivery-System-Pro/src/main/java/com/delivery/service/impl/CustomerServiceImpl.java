package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.exception.CustomerNotFoundException;
import com.delivery.model.Cart;
import com.delivery.model.Customer;
import com.delivery.repository.CustomerRepository;
import com.delivery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		for(Cart cart: customer.getProductList()) {
			cart.setCustomer(customer);
		}
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer findCustomerById(Long id) throws CustomerNotFoundException {
	     return customerRepository.findById(id).get();
	}

	@Override
	public Customer updateCustomerById(Long id, Customer customer) throws CustomerNotFoundException {
		Customer exisiting = customerRepository.findById(id).get();
		exisiting.setCus_name(customer.getCus_name());
		exisiting.setCus_email(customer.getCus_email());
		exisiting.setCus_address(customer.getCus_address());
		exisiting.setCus_phoneNo(customer.getCus_phoneNo());
		customerRepository.save(exisiting);
		return exisiting;
	}

	@Override
	public void deleteCustomerById(Long id) throws CustomerNotFoundException{
		customerRepository.deleteById(id);
	}

	
}
