package com.example.ikea.controller;

import com.example.ikea.exception.InventoryNotFoundException;
import com.example.ikea.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<? extends Object> getInventory() {
        if(inventoryRepository.getInventory() != null && inventoryRepository.getInventory().size() > 0) {
            return new ResponseEntity<>(inventoryRepository.getInventory(), HttpStatus.OK);
        } else {
            throw new InventoryNotFoundException();
        }
    }

}
