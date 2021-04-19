package com.example.ikea.model;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    private String name;
    private List<ContainArticle> contain_articles;
}

