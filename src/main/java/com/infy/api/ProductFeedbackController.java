package com.infy.api;

import com.infy.dto.ProductFeedbackDTO;
import com.infy.entity.ProductFeedback;
import com.infy.exception.InfyBankException;
import com.infy.service.impl.ProductFeedbackService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/market/feedbacks")
@Validated
public class ProductFeedbackController {

    private ProductFeedbackService productFeedbackService;

    private ModelMapper modelMapper;

    @Autowired
    public ProductFeedbackController(ProductFeedbackService productFeedbackService, ModelMapper modelMapper) {
        this.productFeedbackService = productFeedbackService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/byProduct/{productId}")
    public ResponseEntity<List<ProductFeedbackDTO>> getByProduct(@PathVariable @Min(value = 1, message = "Product id should be minimum 1") Integer productId) throws InfyBankException {
        List<ProductFeedback> productFeedbackList = productFeedbackService.getByProduct(productId);
        List<ProductFeedbackDTO> productFeedbackDTOList = new ArrayList<>();
        for (ProductFeedback productFeedback : productFeedbackList) {
            productFeedbackDTOList.add(this.modelMapper.map(productFeedback, ProductFeedbackDTO.class));
        }
        return new ResponseEntity<>(productFeedbackDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/byCustomer/{customerId}")
    public ResponseEntity<List<ProductFeedbackDTO>> getByCustomer(@PathVariable @Min(value = 1, message = "Customer id should be minimum 1") Integer customerId) throws InfyBankException {
        List<ProductFeedback> productFeedbackList = productFeedbackService.getByCustomer(customerId);
        List<ProductFeedbackDTO> productFeedbackDTOList = new ArrayList<>();
        for (ProductFeedback productFeedback : productFeedbackList) {
            productFeedbackDTOList.add(this.modelMapper.map(productFeedback, ProductFeedbackDTO.class));
        }
        return new ResponseEntity<>(productFeedbackDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductFeedbackDTO> save(@Valid @RequestBody ProductFeedbackDTO productFeedbackDTO) {
        ProductFeedback productFeedback = productFeedbackService.save(this.modelMapper.map(productFeedbackDTO, ProductFeedback.class));
        return new ResponseEntity<>(this.modelMapper.map(productFeedback, ProductFeedbackDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{feedbackId}")
    public ResponseEntity<ProductFeedbackDTO> delete(@PathVariable @Min(value = 1, message = "Product feedback id should be minimum 1") Integer productFeedbackId) throws InfyBankException {
        ProductFeedback productFeedback = productFeedbackService.delete(productFeedbackId);
        return new ResponseEntity<>(this.modelMapper.map(productFeedback, ProductFeedbackDTO.class), HttpStatus.OK);
    }
}
