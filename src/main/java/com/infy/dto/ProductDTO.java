package com.infy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Integer id;
    @NotNull(message = "{product.name.absent}")
    @Pattern(regexp="[A-Za-z0-9]+( [A-Za-z0-9]+)*", message = "{product.productName.invalid}")
    private String productName;
    @NotNull(message = "{product.name.absent}")
    private String manufacturer;

    @NotNull(message = "{product.price.absent}")
    private BigDecimal price;

    @NotNull(message = "{product.quantity.absent}")
    private Integer quantity;

    @NotNull(message = "{product.description.absent}")
    private String description;

    private Integer isActive;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String productName, BigDecimal price, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}
