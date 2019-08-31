package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.service.CategoryService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public class CustomProductMapper {

    @Autowired
    private CategoryService categoryService;

    @AfterMapping
    public void dtoToEntity(ProductDTO productDTO, @MappingTarget Product product) {
        product.setCategory(categoryService.getOne(productDTO.getCategoryId()));
        product.setProductFeatures(productDTO.getProductFeatures()
                .stream()
                .map(ProductFeatureMapper.INSTANCE::dtoToEntity)
                .collect(Collectors.toList()));
    }

    @AfterMapping
    public void entityToDto(Product product, @MappingTarget ProductDTO productDTO) {

    }
}
