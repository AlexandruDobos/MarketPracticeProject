package com.infy.repository;

import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
     boolean existsByEmail(String email);


}
