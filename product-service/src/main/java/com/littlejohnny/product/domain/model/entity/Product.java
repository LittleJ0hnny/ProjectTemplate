package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.util.coverters.CustomAttributesConverter;
import com.littlejohnny.product.util.coverters.FeaturesConverter;
import com.littlejohnny.product.util.coverters.ListOfStringsConverter;
import com.littlejohnny.product.util.coverters.AttributesConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private List<AttributeValue> attributeValues;

    @Convert(converter = CustomAttributesConverter.class)
    private Map<String, String> customAttributeValues;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                name.equals(product.name) &&
                price.equals(product.price) &&
                category.getId().equals(product.category.getId()) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imageUrls, product.imageUrls) &&
                Objects.equals(rating, product.rating) &&
                sellerId.equals(product.sellerId) &&
                stockpile.equals(product.stockpile) &&
                creationTime.equals(product.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, description, imageUrls, attributeValues, productFeatures, rating, sellerId, stockpile, creationTime);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category.getName() +
                ", description='" + description + '\'' +
                ", imageUrls=" + imageUrls +
                ", rating=" + rating +
                ", sellerId=" + sellerId +
                ", stockpile=" + stockpile +
                ", creationTime=" + creationTime +
                '}';
    }
}
