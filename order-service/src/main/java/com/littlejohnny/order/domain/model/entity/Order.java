package com.littlejohnny.order.domain.model.entity;

import com.littlejohnny.order.domain.model.OrderState;
import com.littlejohnny.order.domain.model.dto.OrderDTO;
import com.littlejohnny.order.util.converters.ListOfIdsConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Integer rating;

    @Column(nullable = false, updatable = false)
    private Long sellerId;

    @Column(nullable = false, updatable = false)
    private Long buyerId;

    @Convert(converter = ListOfIdsConverter.class)
    private List<Long> productIds;

    @Column(nullable = false)
    private Integer productsPrice;

    @Column
    private Integer deliveryPrice;

    @Column(nullable = false)
    private String deliveryPlace;

    @Column(nullable = false)
    private OrderState orderState;

    @Column(updatable = false)
    private LocalDateTime creationTime;

    @Column(updatable = false)
    private LocalDateTime sendingTime;

    @Column(updatable = false)
    private LocalDateTime deliveryTime;
}
