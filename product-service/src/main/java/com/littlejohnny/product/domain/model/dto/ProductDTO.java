package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private Integer price;

    private Long categoryId;

    private String description;

    private List<String> imageUrls;

    private Map<String, String> attributes;

    private List<ProductFeatureDTO> productFeatures;

    private Byte rating;

    private Long sellerId;

    private Integer stockpile;

    private LocalDateTime creationTime;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categoryId = product.getCategory().getId();
        this.description = product.getDescription();
        this.imageUrls = product.getImageUrls();
        this.attributes = product.getAttributes();
        this.productFeatures = product.getProductFeatures().stream().map(ProductFeatureDTO::new).collect(Collectors.toList());
        this.rating = product.getRating();
        this.sellerId = product.getSellerId();
        this.stockpile = product.getStockpile();
        this.creationTime = product.getCreationTime();
    }
}
