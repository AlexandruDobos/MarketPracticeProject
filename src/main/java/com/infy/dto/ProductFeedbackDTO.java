package com.infy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductFeedbackDTO {
    private Integer id;
    @NotNull(message = "{productFeedback.productId.absent}")
    private Integer productId;
    @NotNull(message = "{productFeedback.customerId.absent}")
    private Integer customerId;
    @NotNull(message = "{productFeedback.comment.absent}")
    private String comment;
    @NotNull(message = "{productFeedback.stars.absent}")
    private Integer stars;
    private Integer isActive;
}
