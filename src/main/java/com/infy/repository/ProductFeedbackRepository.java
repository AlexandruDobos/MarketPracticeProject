package com.infy.repository;

import com.infy.entity.ProductFeedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductFeedbackRepository extends CrudRepository<ProductFeedback, Integer> {
    List<ProductFeedback> getProductFeedbacksByProductId(Integer productId);

    List<ProductFeedback> getProductFeedbacksByCustomerId(Integer customerId);
}
