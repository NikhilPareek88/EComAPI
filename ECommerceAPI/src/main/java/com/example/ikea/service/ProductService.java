package com.example.ikea.service;

import com.example.ikea.model.ContainArticle;
import com.example.ikea.model.InventoryArticle;
import com.example.ikea.model.Product;
import com.example.ikea.repository.InventoryRepository;
import com.example.ikea.repository.ProductRepository;
import com.example.ikea.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public Optional<ApiResponse> updateProductInventory(String productName) {
        Product product = productRepository.getProducts().get(productName);
        boolean allAvailable = true;
        List<InventoryArticle> articleList = new ArrayList<>();
        for(ContainArticle containArticle : product.getContain_articles()) {
            if(inventoryRepository.getInventory().containsKey(containArticle.getArt_id())) {
                InventoryArticle inventoryArticle = new InventoryArticle(inventoryRepository.getInventory().get(containArticle.getArt_id()));
                int availableStock = Integer.parseInt(inventoryArticle.getStock());
                int requiredStock = Integer.parseInt(containArticle.getAmount_of());
                if(availableStock >= requiredStock) {
                    String stockLeft = Integer.toString(availableStock-requiredStock);
                    inventoryArticle.setStock(stockLeft);
                    articleList.add(inventoryArticle);
                } else {
                    allAvailable = false;
                    break;
                }
            } else {
                allAvailable = false;
                break;
            }
        }
        if(allAvailable && articleList.size() >= 1) {
            inventoryRepository.updateInventory(articleList);
            return Optional.of(new ApiResponse(productName + " sold"));
        } else {
            return Optional.empty();
        }
    }

}
