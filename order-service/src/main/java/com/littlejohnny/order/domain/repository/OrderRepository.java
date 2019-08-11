package com.littlejohnny.order.domain.repository;

import com.littlejohnny.order.domain.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
