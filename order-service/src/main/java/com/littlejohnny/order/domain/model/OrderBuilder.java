package com.littlejohnny.order.domain.model;

import com.littlejohnny.order.domain.model.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBuilder {

    private Order order;

    public OrderBuilder() {
        order = new Order();
    }

    public OrderBuilder setId(Long id) {
        order.setId(id);
        return this;
    }

    public OrderBuilder setRating(Byte rating) {
        order.setRating(rating);
        return this;
    }

    public OrderBuilder setSellerId(Long sellerId) {
        order.setSellerId(sellerId);
        return this;
    }

    public OrderBuilder setBuyerId(Long buyerId) {
        order.setBuyerId(buyerId);
        return this;
    }

    public OrderBuilder setProducts(List<Long> products) {
        order.setProducts(products);
        return this;
    }

    public OrderBuilder setProductsPrice(Integer productsPrice) {
        order.setProductsPrice(productsPrice);
        return this;
    }

    public OrderBuilder setDeliveryPrice(Integer deliveryPrice) {
        order.setDeliveryPrice(deliveryPrice);
        return this;
    }

    public OrderBuilder setDeliveryPlace(String deliveryPlace) {
        order.setDeliveryPlace(deliveryPlace);
        return this;
    }

    public OrderBuilder setOrderState(OrderState orderState) {
        order.setOrderState(orderState);
        return this;
    }

    public OrderBuilder setCreationTime(LocalDateTime creationTime) {
        order.setCreationTime(creationTime);
        return this;
    }

    public OrderBuilder setSendingTime(LocalDateTime sendingTime) {
        order.setSendingTime(sendingTime);
        return this;
    }

    public OrderBuilder setDeliveryTime(LocalDateTime deliveryTime) {
        order.setDeliveryTime(deliveryTime);
        return this;
    }

    public Order build() {
        return order;
    }
}
