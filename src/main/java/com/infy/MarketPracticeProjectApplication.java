package com.infy;

import com.infy.dto.CommandDTO;
import com.infy.dto.ProductDTO;
import com.infy.entity.Command;
import com.infy.entity.Product;
import com.infy.service.impl.CommandService;
import com.infy.service.impl.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class MarketPracticeProjectApplication implements CommandLineRunner {

	CommandService commandService;
	ProductService productService;
	//Environment environment;
	private static final Log LOGGER = LogFactory.getLog(MarketPracticeProjectApplication.class);

	@Autowired
	public MarketPracticeProjectApplication(CommandService commandService, Environment environment, ProductService productService) {
		this.commandService = commandService;
		this.productService = productService;
		//this.environment = environment;
	}


	public static void main(String[] args) {
		SpringApplication.run(MarketPracticeProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		//getProductDetails();
		//addProduct();
		//deleteProduct();
		//getCommand();
		//addCommand();
		//addProductToExistingCommand();
		//deleteProductOfExistingCommand();
	}

//	public void addProduct(){
//		try{
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setId(null);
//			productDTO.setProductName("Orange");
//			productDTO.setPrice(BigDecimal.valueOf(2.0));
//			//Product product = productService.save(Product.prepareEntity(productDTO));
//			//System.out.println("Product with id: " + product.getId() + " was added!");
//
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//			//String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
//		}
//	}
//
//	public void getProductDetails(){
//		try{
//			Integer productId = 1;
//			Product productDTO = productService.get(productId);
//			System.out.println(productDTO);
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//		}
//	}
//
//	public void deleteProduct(){
//		try{
//			Integer productId = 1;
//			productService.delete(productId);
//			System.out.println("Product with id: " + productId + " was deleted!");
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//		}
//	}
//
//	public void addCommand(){
//		try{
//			CommandDTO commandDTO = new CommandDTO();
//			commandDTO.setId(null);
//
//			Product product = new Product();
//			product = productService.get(1);
//
//			Product product1 = new Product();
//			product1 = productService.get(2);
//
//			Product product2 = new Product();
//			product2 = productService.get(3);
//
//			List<ProductDTO> productDTOCommandDetailsList = new LinkedList<>();
//			//productDTOCommandDetailsList.add(Product.prepareDTO(product));
//			//productDTOCommandDetailsList.add(Product.prepareDTO(product1));
//			//productDTOCommandDetailsList.add(Product.prepareDTO(product2));
//
//			commandDTO.setProducts(productDTOCommandDetailsList);
//
//			//Command command = commandService.save(Command.prepareEntity(commandDTO));
//			System.out.println("Command with was added!");
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//		}
//	}
//
//	public void getCommand(){
//		try{
//			Integer commandId = 1;
//			Command command = commandService.get(commandId);
//			System.out.println(command);
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//		}
//	}
//
//	public void addProductToExistingCommand(){
//		try{
//			Integer commandId = 1;
//			Product product = productService.get(3);
//			//commandService.addProductToExistingCommand(commandId, product);
//			System.out.println("Product added successfully to command " + commandId);
//		}catch (Exception e){
//			System.out.println("Some exception occurred. Please check log file for more details!!");
//		}
//	}

}
