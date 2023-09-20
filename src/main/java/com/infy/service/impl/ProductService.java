package com.infy.service.impl;

import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.repository.ProductRepository;
import com.infy.service.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "productService")
@Transactional
public class ProductService implements IProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) throws InfyBankException {
        if (!productRepository.existsByProductNameAndManufacturer(product.getProductName(), product.getManufacturer())) {
            productRepository.save(product);
            return product;
        }
        throw new InfyBankException("Service.PRODUCT_ALREADY_EXISTS");

    }

    @Override
    public Product get(Integer productId) throws InfyBankException {
        Optional<Product> optional = productRepository.findById(productId);
        Product product = optional.orElseThrow(() -> new InfyBankException("Service.PRODUCT_NOT_FOUND"));
        return product;
    }

    @Override
    public List<Product> getAll() throws InfyBankException {
        List<Product> products = (List<Product>) productRepository.findAll();
        if (products.isEmpty()) {
            throw new InfyBankException("Service.PRODUCTS_NOT_FOUND");
        }
        return products;
    }


    @Override
    public Product partialUpdate(Integer productId, Map<String, Object> updates) throws InfyBankException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product p = optionalProduct.orElseThrow(() -> new InfyBankException("Service.PRODUCT_NOT_FOUND"));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "productName": {
                        p.setProductName(entry.getValue().toString());
                        break;
                    }
                    case "manufacturer": {
                        p.setManufacturer(entry.getValue().toString());
                        break;
                    }
                    case "price": {
                        p.setPrice(BigDecimal.valueOf((Double) entry.getValue()));
                        break;
                    }
                    case "quantity": {
                        p.setQuantity((Integer) entry.getValue());
                        break;
                    }
                    case "description": {
                        p.setDescription(entry.getValue().toString());
                        break;
                    }
                }
            }
        }
        return p;
    }

    @Override
    public Product delete(Integer productId) throws InfyBankException {
        Optional<Product> optional = productRepository.findById(productId);
        Product product = optional.orElseThrow(() -> new InfyBankException("Service.PRODUCT_NOT_FOUND"));
        product.setIsActive(0);
        return product;
    }


}
