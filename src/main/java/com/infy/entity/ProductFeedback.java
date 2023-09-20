package com.infy.entity;

import com.infy.dto.ProductFeedbackDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ProductFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "customer_id")
    private Integer customerId;
    private String comment;
    private Integer stars;
    @Column(name = "is_active")
    private Integer isActive;

    /*
    public static ProductFeedback prepareEntity(ProductFeedbackDTO productFeedbackDTO) {
        ProductFeedback productFeedback = new ProductFeedback();
        productFeedback.setId(productFeedbackDTO.getId());
        productFeedback.setProductId(productFeedbackDTO.getProductId());
        productFeedback.setCustomerId(productFeedbackDTO.getCustomerId());
        productFeedback.setComment(productFeedbackDTO.getComment());
        productFeedback.setStars(productFeedbackDTO.getStars());
        return productFeedback;
    }

    public static ProductFeedbackDTO prepareDTO(ProductFeedback productFeedback) {
        ProductFeedbackDTO productFeedbackDTO = new ProductFeedbackDTO();
        productFeedbackDTO.setId(productFeedback.getId());
        productFeedbackDTO.setProductId(productFeedback.getProductId());
        productFeedbackDTO.setCustomerId(productFeedback.getCustomerId());
        productFeedbackDTO.setComment(productFeedback.getComment());
        productFeedbackDTO.setStars(productFeedback.getStars());
        return productFeedbackDTO;
    }

    public static List<ProductFeedback> prepareEntityList(List<ProductFeedbackDTO> productFeedbackDTOSList) {
        List<ProductFeedback> productFeedbackList = new ArrayList<>();
        for (ProductFeedbackDTO productFeedbackDTO : productFeedbackDTOSList) {
            productFeedbackList.add(ProductFeedback.prepareEntity(productFeedbackDTO));
        }
        return productFeedbackList;
    }

    public static List<ProductFeedbackDTO> prepareDTOList(List<ProductFeedback> productFeedbackList) {
        List<ProductFeedbackDTO> productFeedbackDTOS = new ArrayList<>();
        for (ProductFeedback productFeedback : productFeedbackList) {
            productFeedbackDTOS.add(ProductFeedback.prepareDTO(productFeedback));
        }
        return productFeedbackDTOS;
    }
*/
}
