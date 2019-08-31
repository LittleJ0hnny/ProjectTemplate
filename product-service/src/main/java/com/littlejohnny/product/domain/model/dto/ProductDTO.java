package com.littlejohnny.product.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private Integer price;

    private Long categoryId;

    private String description;

    private List<String> imageUrls;

    private List<AttributeValueDTO> attributeValues;

    private List<ProductFeatureDTO> productFeatures;

    private Integer rating;

    private Long sellerId;

    private Integer stockpile;

    private LocalDateTime creationTime;
}
