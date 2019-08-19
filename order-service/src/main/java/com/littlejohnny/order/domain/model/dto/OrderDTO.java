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

    private Integer rating;

    private Long sellerId;

    private Long buyerId;

    private List<Long> productIds;

    private Integer productsPrice;

    private Integer deliveryPrice;

    private String deliveryPlace;

    private OrderState orderState;

    private LocalDateTime creationTime;

    private LocalDateTime sendingTime;

    private LocalDateTime deliveryTime;
}
