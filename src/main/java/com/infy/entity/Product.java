package com.infy.entity;

import com.infy.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String productName;

    private String manufacturer;

    private BigDecimal price;

    private Integer quantity;

    private String description;

    @Column(name = "is_Active")
    private Integer isActive;


    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (this.getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!this.getId().equals(other.getId()))
            return false;
        return true;
    }

    /*
    public static Product prepareEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setManufacturer(productDTO.getManufacturer());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }

    public static ProductDTO prepareDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setManufacturer(product.getManufacturer());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        return productDTO;
    }

    public static List<Product> prepareEntityList(List<ProductDTO> productDTOList) {
        List<Product> productList = new ArrayList<>();
        for (ProductDTO productDTO : productDTOList) {
            Product product = Product.prepareEntity(productDTO);
            productList.add(product);
        }
        return productList;
    }

    public static List<ProductDTO> prepareDTOList(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = Product.prepareDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

     */
}
