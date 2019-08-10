package com.littlejohnny.product.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
