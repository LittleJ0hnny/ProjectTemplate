package com.littlejohnny.order.domain.model.dto;

import com.littlejohnny.order.domain.model.OrderState;
import com.littlejohnny.order.domain.model.entity.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    private Byte rating;

    private Long sellerId;

    private Long buyerId;

    private List<Long> products;

    private Integer productsPrice;

    private Integer deliveryPrice;

    private String deliveryPlace;

    private OrderState orderState;

    private LocalDateTime creationTime;

    private LocalDateTime sendingTime;

    private LocalDateTime deliveryTime;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.rating = order.getRating();
        this.sellerId = order.getSellerId();
        this.buyerId = order.getBuyerId();
        this.products = order.getProducts();
        this.productsPrice = order.getProductsPrice();
        this.deliveryPrice = order.getDeliveryPrice();
        this.deliveryPlace = order.getDeliveryPlace();
        this.orderState = order.getOrderState();
        this.creationTime = order.getCreationTime();
        this.sendingTime = order.getSendingTime();
        this.deliveryTime = order.getDeliveryTime();
    }
}
