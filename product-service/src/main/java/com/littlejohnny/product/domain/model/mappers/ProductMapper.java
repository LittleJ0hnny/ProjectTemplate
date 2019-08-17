package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO entityToDto(Product product);

    Product dtoToEntity(ProductDTO productDTO);
}
