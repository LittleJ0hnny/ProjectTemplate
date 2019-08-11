package com.littlejohnny.product.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "features")
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Product product;

    private String iconUrl;
}
