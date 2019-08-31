package com.littlejohnny.order.domain.controller;

import com.littlejohnny.order.domain.model.dto.OrderDTO;
import com.littlejohnny.order.domain.model.mappers.OrderMapper;
import com.littlejohnny.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.save(OrderMapper.INSTANCE.dtoToEntity(orderDTO));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return OrderMapper.INSTANCE.entityToDto(orderService.getOne(id));
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.findAll().stream().map(OrderMapper.INSTANCE::entityToDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
