package com.delivery.service;

import java.util.List;

import com.delivery.model.Customer;

public interface CustomerService {

	List<Customer> findAllCustomer();

	Customer addCustomer(Customer customer);

	Customer findCustomerById(Long id);

	Customer updateCustomerById(Long id, Customer customer);

	void deleteCustomerById(Long id);

}
