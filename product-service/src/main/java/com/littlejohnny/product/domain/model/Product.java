package com.littlejohnny.product.domain.model;

import com.littlejohnny.product.util.coverters.MapToStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "articles")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Integer price;

    private String description;

    private List<String> imageUrls;

    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> attributes;

    private List<ProductFeature> features;

    private Byte rating;

    private Long sellerId;

    private Integer stockpile;

    private LocalDateTime creationTime;
}
