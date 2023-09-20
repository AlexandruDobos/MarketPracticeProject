package com.infy.dto;

import com.infy.entity.enumeration.PaymentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
public class CommandDTO {

    private Integer id;
    @NotNull(message = "{command.products.absent}")
    @Valid
    private List<ProductDTO> products;
    @NotNull(message = "{command.price.absent}")
    private BigDecimal price;
    @NotNull(message = "{command.date.absent}")
    @PastOrPresent(message = "{command.date.invalid}")
    private Date date;
    @NotNull(message = "{command.dispatchDate.absent}")
    private Date dispatchDate;
    @NotNull(message = "{command.receiptDate.absent}")
    private Date receiptDate;
    @NotNull(message = "{command.status.absent}")
    private String status;
    @NotNull(message = "{command.paymentType.absent}")
    private PaymentType paymentType;
    @NotNull(message = "{command.customer.absent}")
    @Valid
    private CustomerDTO customerDTO;


}
