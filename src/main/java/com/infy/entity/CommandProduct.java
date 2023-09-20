package com.infy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "command_products")
@Data
public class CommandProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "command_id")
    private Integer commandId;
    @Column(name = "products_id")
    private Integer productId;
    private Integer quantity;

}
