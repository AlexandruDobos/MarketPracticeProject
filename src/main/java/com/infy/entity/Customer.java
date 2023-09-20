package com.infy.entity;

import com.infy.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    @Column(name = "is_active")
    private int isActive;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Command> commandList;
/*
    public static Customer prepareEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setCountry(customerDTO.getCountry());
        return customer;
    }

    public static CustomerDTO prepareDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setCity(customer.getCity());
        customerDTO.setState(customer.getState());
        customerDTO.setPostalCode(customer.getPostalCode());
        customerDTO.setCountry(customer.getCountry());
        customer.setCommandList(customer.getCommandList());
        return customerDTO;
    }

    public static List<Customer> prepareEntityList(List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerDTO customerDTO : customerDTOList) {
            Customer customer = Customer.prepareEntity(customerDTO);
            customerList.add(customer);
        }
        return customerList;
    }

    public static List<CustomerDTO> prepareDTOList(List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = Customer.prepareDTO(customer);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

 */
}
