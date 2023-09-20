package com.infy.service.impl;

import com.infy.dto.CommandDTO;
import com.infy.dto.CustomerDTO;
import com.infy.entity.Command;
import com.infy.entity.Customer;
import com.infy.entity.Employee;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.repository.CommandRepository;
import com.infy.repository.CustomerRepository;
import com.infy.service.ICustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service(value = "customerService")
@Transactional
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer get(Integer customerId) throws InfyBankException {
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        return customer;
    }

    @Override
    public List<Customer> getAll() throws InfyBankException {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new InfyBankException("Service.CUSTOMERS_NOT_FOUND");
        }
        return customers;
    }

    @Override
    public Customer save(Customer customer) throws InfyBankException {
        if (!customerRepository.existsByEmail(customer.getEmail())) {
            customerRepository.save(customer);
            return customer;
        } else {
            throw new InfyBankException("Service.CUSTOMER_ALREADY_EXISTS");
        }
    }

    @Override
    public Customer partialUpdate(Integer customerId, Map<String, Object> updates) throws InfyBankException {
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "firstName": {
                        customer.setFirstName(entry.getValue().toString());
                        break;
                    }
                    case "lastName": {
                        customer.setLastName(entry.getValue().toString());
                        break;
                    }
                    case "email": {
                        customer.setEmail(entry.getValue().toString());
                        break;
                    }
                    case "phone": {
                        customer.setPhone(entry.getValue().toString());
                        break;
                    }
                    case "address": {
                        customer.setAddress(entry.getValue().toString());
                        break;
                    }
                    case "city": {
                        customer.setCity(entry.getValue().toString());
                        break;
                    }
                    case "state": {
                        customer.setState(entry.getValue().toString());
                        break;
                    }
                    case "postalCode": {
                        customer.setPostalCode(entry.getValue().toString());
                        break;
                    }
                    case "country": {
                        customer.setCountry(entry.getValue().toString());
                        break;
                    }
                    case "commandList": {
                        customer.setCommandList((List<Command>) entry.getValue());
                        break;
                    }
                }
            }
        }
        return customer;
    }

    @Override
    public Customer delete(Integer customerId) throws InfyBankException {
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        customer.setIsActive(0);
        //customerRepository.delete(customer);
        return customer;
    }


}
