package com.infy;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;
import com.infy.repository.ProductRepository;
import com.infy.service.IProductService;
import com.infy.service.impl.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class MarketPracticeProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	IProductService productService = new ProductService(productRepository);

	@Test
	public void addProductTestValidCredentials() throws InfyBankException {
		Product product = new Product();
		product.setProductName("Pen");
		product.setManufacturer("Manufacturer");
		product.setQuantity(100);
		product.setDescription("Blue color");
		product.setIsActive(1);
		product.setPrice(BigDecimal.valueOf(2));

		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product product1 = productService.save(product);
		Assertions.assertEquals(productRepository.save(product), product1);
	}

	@Test
	public void getProductTest() {
		Product product = new Product();

		Mockito.when(productRepository.findById(11)).thenReturn(null);
		Optional<Product> product1 = productRepository.findById(11);
		Assertions.assertEquals(null, product);
	}
}
