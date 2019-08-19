package com.littlejohnny.order.domain.model.mappers;

import com.littlejohnny.order.domain.model.dto.WishListDTO;
import com.littlejohnny.order.domain.model.entity.WishList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WishListMapper {

    WishListMapper INSTANCE = Mappers.getMapper(WishListMapper.class);

    WishListDTO entityToDto(WishList wishList);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true)
    })
    WishList dtoToEntity(WishListDTO wishListDTO);
}
