package com.littlejohnny.order.domain.model.mappers;

import com.littlejohnny.order.domain.model.dto.OrderDTO;
import com.littlejohnny.order.domain.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO entityToDto(Order order);

    Order dtoToEntity(OrderDTO orderDTO);
}
