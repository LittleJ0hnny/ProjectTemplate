package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.util.coverters.FeaturesConverter;
import com.littlejohnny.product.util.coverters.ListOfStringsConverter;
import com.littlejohnny.product.util.coverters.AttributesConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @Column(nullable = false)
    private String description;

    @Convert(converter = ListOfStringsConverter.class)
    private List<String> imageUrls;

    @Convert(converter = AttributesConverter.class)
    private Map<String, String> attributes;

    @Convert(converter = FeaturesConverter.class)
    private List<ProductFeature> productFeatures;

    @Column
    private Byte rating;

    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false)
    private Integer stockpile;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
}
