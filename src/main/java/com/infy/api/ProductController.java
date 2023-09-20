package com.infy.api;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.service.impl.ProductService;
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
import java.util.Map;

@RestController
@RequestMapping(value = "/market/products")
@Validated
public class ProductController {

    private ProductService productService;

    private ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDTO> get(@PathVariable Integer productId) throws InfyBankException {
        Product product = productService.get(productId);
        return new ResponseEntity<>(this.modelMapper.map(product, ProductDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() throws InfyBankException {
        List<Product> productList = productService.getAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : productList){
            productDTOList.add(this.modelMapper.map(product, ProductDTO.class));
        }
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO) throws InfyBankException {
        Product product = productService.save(this.modelMapper.map(productDTO, Product.class));
        return new ResponseEntity<>(this.modelMapper.map(product, ProductDTO.class), HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{productId}")
    public ResponseEntity<ProductDTO> partialUpdate(@PathVariable Integer productId, @RequestBody Map<String, Object> productUpdates) throws InfyBankException{
        Product product = productService.partialUpdate(productId, productUpdates);
        return new ResponseEntity<>(this.modelMapper.map(product, ProductDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Integer productId) throws InfyBankException {
        Product product = productService.delete(productId);
        return new ResponseEntity<>(this.modelMapper.map(product, ProductDTO.class), HttpStatus.OK);
    }


}
