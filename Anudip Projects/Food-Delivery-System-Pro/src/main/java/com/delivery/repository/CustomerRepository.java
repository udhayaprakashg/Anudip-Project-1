package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
