package com.example.ikea.repository;

import com.example.ikea.model.ContainArticle;
import com.example.ikea.model.Product;
import com.example.ikea.model.Products;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    private Map<String, Product> mapProduct = new HashMap<>();

    public Map<String, Product> getProducts() {
        return mapProduct;
    }

    public void setProducts(Products products) {
        for(Product product: products.getProducts()) {
            mapProduct.put(product.getName(), product);
        }
    }

}
