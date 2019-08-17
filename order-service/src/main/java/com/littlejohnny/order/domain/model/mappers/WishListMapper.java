package com.littlejohnny.order.domain.model.mappers;

import com.littlejohnny.order.domain.model.dto.WishListDTO;
import com.littlejohnny.order.domain.model.entity.WishList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WishListMapper {

    WishListMapper INSTANCE = Mappers.getMapper(WishListMapper.class);

    WishListDTO entityToDto(WishList wishList);

    WishList dtoToEntity(WishListDTO wishListDTO);
}
