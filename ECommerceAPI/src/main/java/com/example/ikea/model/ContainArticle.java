package com.example.ikea.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContainArticle {
    private String art_id;
    private String amount_of;
}
