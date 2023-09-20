package com.infy.api;

import com.infy.dto.CommandDTO;
import com.infy.dto.CustomerDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.Customer;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.service.impl.CommandService;
import com.infy.service.impl.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/market/customers")
@Validated
public class CustomerController {

    private CustomerService customerService;

    private CommandService commandService;

    private ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, CommandService commandService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.commandService = commandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDTO> get(@PathVariable Integer customerId) throws InfyBankException{
        Customer customer = customerService.get(customerId);
        return new ResponseEntity<>(this.modelMapper.map(customer, CustomerDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() throws InfyBankException {
        List<Customer> customerList = customerService.getAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : customerList){
            customerDTOList.add(this.modelMapper.map(customer, CustomerDTO.class));
        }
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO) throws InfyBankException {
        Customer customer = customerService.save(this.modelMapper.map(customerDTO, Customer.class));
        return new ResponseEntity<>(this.modelMapper.map(customer, CustomerDTO.class), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDTO> partialUpdate(@PathVariable Integer customerId, @RequestBody Map<String, Object> customerUpdates) throws InfyBankException{
        Customer customer = customerService.partialUpdate(customerId, customerUpdates);
        return new ResponseEntity<>(this.modelMapper.map(customer, CustomerDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable Integer customerId) throws InfyBankException {
        Customer customer = customerService.delete(customerId);
        return new ResponseEntity<>(this.modelMapper.map(customer, CustomerDTO.class), HttpStatus.OK);
    }



}
