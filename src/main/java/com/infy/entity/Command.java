package com.infy.entity;

import com.infy.dto.CommandDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.enumeration.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Product> products;
    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dispatch_date")
    private Date dispatchDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "receipt_date")
    private Date receiptDate;
    private String status;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Command other = (Command) obj;
        if (this.getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!this.getId().equals(other.getId()))
            return false;
        return true;
    }

//    public static Command prepareEntity(CommandDTO commandDTO) {
//        Command command = new Command();
//        command.setId(commandDTO.getId());
//        command.setPrice(commandDTO.getPrice());
//        command.setDate(commandDTO.getDate());
////        List<Product> productList = new ArrayList<>();
////        for (ProductDTO productDTO : commandDTO.getProducts()) {
////            Product product = Product.prepareEntity(productDTO);
////            productList.add(product);
////        }
////        command.setProducts(productList);
//        command.setDispatchDate(commandDTO.getDispatchDate());
//        command.setReceiptDate(commandDTO.getReceiptDate());
//        command.setStatus(commandDTO.getStatus());
//        command.setPaymentType(commandDTO.getPaymentType());
//        command.setCustomer(Customer.prepareEntity(commandDTO.getCustomerDTO()));
//        return command;
//    }
//
//    public static CommandDTO prepareDTO(Command command) {
//        CommandDTO commandDTO = new CommandDTO();
//        commandDTO.setId(command.getId());
//        commandDTO.setPrice(command.getPrice());
//        commandDTO.setDate(command.getDate());
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        for (Product product : command.getProducts()) {
//            ProductDTO productDTO = Product.prepareDTO(product);
//            productDTOList.add(productDTO);
//        }
//        commandDTO.setProducts(productDTOList);
//        commandDTO.setDispatchDate(command.getDispatchDate());
//        commandDTO.setReceiptDate(command.getReceiptDate());
//        commandDTO.setStatus(command.getStatus());
//        commandDTO.setPaymentType(command.getPaymentType());
//        commandDTO.setCustomerDTO(Customer.prepareDTO(command.getCustomer()));
//        return commandDTO;
//    }
//
//    public static List<Command> prepareEntityList(List<CommandDTO> commandDTOList) {
//        List<Command> commandList = new ArrayList<>();
//        for (CommandDTO commandDTO : commandDTOList) {
//            Command command = Command.prepareEntity(commandDTO);
//            commandList.add(command);
//        }
//        return commandList;
//    }
//
//    public static List<CommandDTO> prepareDTOList(List<Command> commandList) {
//        List<CommandDTO> commandDTOList = new ArrayList<>();
//        for (Command command : commandList) {
//            CommandDTO commandDTO = Command.prepareDTO(command);
//            commandDTOList.add(commandDTO);
//        }
//        return commandDTOList;
//    }

}
