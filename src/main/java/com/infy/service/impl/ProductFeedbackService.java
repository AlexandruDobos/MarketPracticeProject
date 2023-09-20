package com.infy.service.impl;

import com.infy.entity.Customer;
import com.infy.entity.Product;
import com.infy.entity.ProductFeedback;
import com.infy.exception.InfyBankException;
import com.infy.repository.ProductFeedbackRepository;
import com.infy.service.IProductFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service(value = "productFeedbackService")
@Transactional
public class ProductFeedbackService implements IProductFeedbackService {

    private ProductFeedbackRepository productFeedbackRepository;

    @Autowired
    public ProductFeedbackService(ProductFeedbackRepository productFeedbackRepository) {
        this.productFeedbackRepository = productFeedbackRepository;
    }

    @Override
    public ProductFeedback save(ProductFeedback productFeedback) {
        productFeedbackRepository.save(productFeedback);
        return productFeedback;
    }

    @Override
    public List<ProductFeedback> getByProduct(Integer productId) throws InfyBankException {
        return productFeedbackRepository.getProductFeedbacksByProductId(productId);
    }

    @Override
    public List<ProductFeedback> getByCustomer(Integer customerId) throws InfyBankException {
        return productFeedbackRepository.getProductFeedbacksByCustomerId(customerId);
    }

    @Override
    public ProductFeedback delete(Integer productFeedbackId) throws InfyBankException {
        Optional<ProductFeedback> optional = productFeedbackRepository.findById(productFeedbackId);
        ProductFeedback productFeedback = optional.orElseThrow(() -> new InfyBankException("Service.FEEDBACK_NOT_FOUND"));
        productFeedbackRepository.delete(productFeedback);
        return productFeedback;
    }
}
