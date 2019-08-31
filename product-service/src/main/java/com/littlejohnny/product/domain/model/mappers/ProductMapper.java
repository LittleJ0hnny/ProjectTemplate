package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.service.CategoryService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO entityToDto(Product product);

    Product dtoToEntity(ProductDTO productDTO);

    @AfterMapping
    default void dtoToEntity(ProductDTO productDTO, @MappingTarget Product product, @Context CategoryService categoryService) {
        product.setCategory(categoryService.getOne(productDTO.getCategoryId()));
        product.setProductFeatures(productDTO.getProductFeatures()
                .stream()
                .map(ProductFeatureMapper.INSTANCE::dtoToEntity)
                .collect(Collectors.toList()));
    }
}
