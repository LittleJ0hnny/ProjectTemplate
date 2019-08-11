package com.littlejohnny.order.domain.model;

import com.littlejohnny.product.domain.model.Article;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long userId;

    private Map<Article, Long> articles;
}
