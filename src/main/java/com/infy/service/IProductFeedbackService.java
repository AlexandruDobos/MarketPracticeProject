package com.infy.service;

import com.infy.entity.Customer;
import com.infy.entity.Product;
import com.infy.entity.ProductFeedback;
import com.infy.exception.InfyBankException;

import java.util.List;

public interface IProductFeedbackService {

    ProductFeedback save(ProductFeedback productFeedback);

    List<ProductFeedback> getByProduct(Integer productId) throws InfyBankException;

    List<ProductFeedback> getByCustomer(Integer customerId) throws InfyBankException;

    ProductFeedback delete(Integer productFeedbackId) throws InfyBankException;

}
