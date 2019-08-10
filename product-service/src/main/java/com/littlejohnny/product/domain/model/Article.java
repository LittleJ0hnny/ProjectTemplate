package com.littlejohnny.product.domain.model;

import com.littlejohnny.product.util.coverters.MapToStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Integer price;

    private Integer stockpile;

    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> attributes;

    private String description;
}
