package com.example.ikea.repository;

import com.example.ikea.model.Inventory;
import com.example.ikea.model.InventoryArticle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InventoryRepository {

    private Map<String, InventoryArticle> inventoryMap = new HashMap<>();

    public Map<String, InventoryArticle> getInventory() {
        return inventoryMap;
    }

    public void setInventory(Inventory inventory) {
        if(inventory!=null) {
            for (InventoryArticle ia : inventory.getArticles()) {
                inventoryMap.put(ia.getArt_id(), ia);
            }
        } else {
            inventoryMap = null;
        }
    }

    public void updateInventory(List<InventoryArticle> articles) {
        if(articles.size() > 0) {
            for (InventoryArticle ia : articles) {
                inventoryMap.put(ia.getArt_id(), ia);
            }
        }
    }

}
