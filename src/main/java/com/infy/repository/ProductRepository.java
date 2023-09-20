package com.infy.repository;

import com.infy.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    boolean existsByProductNameAndManufacturer(String productName, String manufacturer);
}
