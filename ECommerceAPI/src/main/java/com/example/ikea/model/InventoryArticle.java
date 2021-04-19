package com.example.ikea.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryArticle {

    public InventoryArticle(InventoryArticle article) {
        this.art_id = article.art_id;
        this.name = article.name;
        this.stock = article.stock;
    }
    private String art_id;
    private String name;
    private String stock;
}
