package com.example.ikea;

import com.example.ikea.model.Inventory;
import com.example.ikea.model.Products;
import com.example.ikea.repository.InventoryRepository;
import com.example.ikea.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ikea")
public class ECommerceAPIApplication {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceAPIApplication.class, args);
	}

	@PostConstruct
	public void importData() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			Products products = mapper.readValue(ECommerceAPIApplication.class.getClass().getResourceAsStream("/static/products.json"), Products.class);
			Inventory inventory = mapper.readValue(ECommerceAPIApplication.class.getClass().getResourceAsStream("/static/inventory.json"), Inventory.class);
			productRepository.setProducts(products);
			inventoryRepository.setInventory(inventory);
		} catch (Exception e) {
			throw e;
		}
	}

}
