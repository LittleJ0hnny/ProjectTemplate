package com.littlejohnny.order.domain.service.impl;

import com.littlejohnny.order.domain.model.entity.Order;
import com.littlejohnny.order.domain.repository.OrderRepository;
import com.littlejohnny.order.domain.service.AbstractService;
import com.littlejohnny.order.domain.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, Long, OrderRepository> implements OrderService {

    protected OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
