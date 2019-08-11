package com.littlejohnny.product.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category_attributes")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Product product;

    private CategoryAttributes categoryAttributes;

    private Category parentCategory;
}