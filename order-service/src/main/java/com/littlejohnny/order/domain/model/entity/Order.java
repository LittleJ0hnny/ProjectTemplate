package com.littlejohnny.order.domain.model.entity;

import com.littlejohnny.order.domain.model.OrderBuilder;
import com.littlejohnny.order.domain.model.OrderState;
import com.littlejohnny.order.domain.model.dto.OrderDTO;
import com.littlejohnny.order.util.converters.ListToStringConverter;
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
    private Byte rating;

    @Column(nullable = false, updatable = false)
    private Long sellerId;

    @Column(nullable = false, updatable = false)
    private Long buyerId;

    @Convert(converter = ListToStringConverter.class)
    private List<Long> products;

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

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.rating = orderDTO.getRating();
        this.sellerId = orderDTO.getSellerId();
        this.buyerId = orderDTO.getBuyerId();
        this.products = orderDTO.getProducts();
        this.productsPrice = orderDTO.getProductsPrice();
        this.deliveryPrice = orderDTO.getDeliveryPrice();
        this.deliveryPlace = orderDTO.getDeliveryPlace();
        this.orderState = orderDTO.getOrderState();
        this.creationTime = orderDTO.getCreationTime();
        this.sendingTime = orderDTO.getSendingTime();
        this.deliveryTime = orderDTO.getDeliveryTime();
    }
}
