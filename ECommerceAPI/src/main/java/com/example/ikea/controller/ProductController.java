package com.example.ikea.controller;

import com.example.ikea.exception.ProductNotFoundException;
import com.example.ikea.model.Product;
import com.example.ikea.repository.ProductRepository;
import com.example.ikea.response.ApiResponse;
import com.example.ikea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HttpEntity<? extends Object> getProducts() {
        if(productRepository.getProducts() != null && productRepository.getProducts().size() > 0) {
            return new ResponseEntity<Set<Map.Entry<String, Product>>>(productRepository.getProducts().entrySet(), HttpStatus.OK);
        } else {
            throw new ProductNotFoundException();
        }
    }

    @PostMapping(value = "/sell/product_item/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ApiResponse> productSell(@PathVariable("productName") String productName) {
        if(productRepository.getProducts().containsKey(productName)) {
            Optional<ApiResponse> optionalApiResponse = productService.updateProductInventory(productName);
            if(optionalApiResponse.isPresent()) {
                return new ResponseEntity<>(optionalApiResponse.get(), HttpStatus.ACCEPTED);
            }
        }
        throw new ProductNotFoundException();
    }

}
