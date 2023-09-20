package com.infy.service;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IProductService {

    Product save(Product product) throws InfyBankException;

    Product get(Integer productId) throws InfyBankException;

    List<Product> getAll() throws InfyBankException;

//    Product update(Integer productId, Product productPrice) throws InfyBankException;

    Product partialUpdate(Integer productId, Map<String, Object> updates) throws InfyBankException;
    Product delete(Integer productId) throws InfyBankException;




}
