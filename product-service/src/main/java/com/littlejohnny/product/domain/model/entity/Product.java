package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.domain.model.dto.AttributeValueDTO;
import com.littlejohnny.product.util.coverters.FeaturesConverter;
import com.littlejohnny.product.util.coverters.ListOfStringsConverter;
import com.littlejohnny.product.util.coverters.AttributesConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(nullable = false)
    private String description;

    @Convert(converter = ListOfStringsConverter.class)
    private List<String> imageUrls;

    @Convert(converter = AttributesConverter.class)
    private List<AttributeValueDTO> attributeValues;

    @Convert(converter = FeaturesConverter.class)
    private List<ProductFeature> productFeatures;

    @Column
    private Integer rating;

    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false)
    private Integer stockpile;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
}
