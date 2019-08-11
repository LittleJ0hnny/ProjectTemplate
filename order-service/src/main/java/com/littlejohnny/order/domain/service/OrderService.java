package com.littlejohnny.order.domain.service;

import com.littlejohnny.order.domain.model.entity.Order;
import com.littlejohnny.order.domain.repository.OrderRepository;

public interface OrderService extends Service<Order, Long, OrderRepository> {
}
