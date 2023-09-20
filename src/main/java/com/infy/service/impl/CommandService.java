package com.infy.service.impl;

import com.infy.dto.CommandDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.Command;
import com.infy.entity.CommandProduct;
import com.infy.entity.Customer;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.repository.CommandProductRepository;
import com.infy.repository.CommandRepository;
import com.infy.repository.CustomerRepository;
import com.infy.repository.ProductRepository;
import com.infy.service.ICommandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service(value = "CommandService")
@Transactional
public class CommandService implements ICommandService {

    private CommandRepository commandRepository;

    private ProductRepository productRepository;

    private CustomerRepository customerRepository;

    private CommandProductRepository commandProductRepository;

    @Autowired
    public CommandService(CommandRepository commandRepository, ProductRepository productRepository, CustomerRepository customerRepository, CommandProductRepository commandProductRepository) {
        this.commandRepository = commandRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.commandProductRepository = commandProductRepository;
    }


    @Override
    public Command save(Command command) throws InfyBankException {
        System.out.println(command);
        commandRepository.save(command);
        for (Product product : command.getProducts()) {
            CommandProduct commandProduct = new CommandProduct();
            commandProduct.setCommandId(command.getId());
            commandProduct.setProductId(product.getId());
            commandProduct.setQuantity(product.getQuantity());
            Optional<Product> optionalProduct = productRepository.findById(product.getId());
            if (optionalProduct.get().getQuantity() - product.getQuantity() > 0) {
                optionalProduct.get().setQuantity(optionalProduct.get().getQuantity() - product.getQuantity());
            } else {
                throw new InfyBankException("Too much quantity for this product.");
            }
            commandProductRepository.save(commandProduct);
        }
        return command;
    }

    @Override
    public Command get(Integer commandId) throws InfyBankException {
        Optional<Command> optional = commandRepository.findById(commandId);
        Command command = optional.orElseThrow(() -> new InfyBankException("SERVICE.COMMAND_NOT_FOUND"));
        return command;
    }

    @Override
    public List<Command> getAll (Integer customerId) throws InfyBankException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer c = customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        List<Command> commands = commandRepository.getCommandsByCustomerId(customerId);
        return commands;
    }

    @Override
    public List<Command> getByDate(Map<String, Object> dates) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(simpleDateFormat.parse(dates.get("data1").toString()));
        List<Command> commands = commandRepository.findByDate(simpleDateFormat.parse(dates.get("data1").toString()));
        return commands;
    }

    @Override
    public List<Command> getAllBetweenTwoDates(Map<String, Object> dates) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(simpleDateFormat.parse(dates.get("data1").toString()));
        List<Command> commands = commandRepository.findByDateBetween(simpleDateFormat.parse(dates.get("data1").toString()),
                simpleDateFormat.parse(dates.get("data2").toString()));
        return commands;
    }

    @Override
    public Command partialUpdate(Integer commandId, Map<String, Object> updates) throws InfyBankException, ParseException {
        Optional<Command> optional = commandRepository.findById(commandId);
        Command command = optional.orElseThrow(() -> new InfyBankException("Service.COMMAND_NOT_FOUND"));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "dispatchDate": {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        command.setDispatchDate(simpleDateFormat.parse(entry.getValue().toString()));
                        break;
                    }
                    case "receiptDate" : {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        command.setReceiptDate(simpleDateFormat.parse(entry.getValue().toString()));
                        break;
                    }
                    case "status" : {
                        command.setStatus((String) entry.getValue());
                        break;
                    }

                }
            }
        }
        return command;
    }



}
