package com.infy.service;

import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    Customer get(Integer customerId) throws InfyBankException;

    List<Customer> getAll() throws InfyBankException;

    Customer save(Customer customer) throws InfyBankException;

    Customer partialUpdate(Integer customerId, Map<String, Object> updates) throws InfyBankException;
    Customer delete(Integer customerId) throws InfyBankException;


}
