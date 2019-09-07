package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.service.CategoryService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel="spring")
public abstract class AttributeMapper {

    private static CategoryService categoryService;

    public abstract AttributeDTO entityToDto(Attribute attribute);

    public abstract Attribute dtoToEntity(AttributeDTO attributeDTO);

    @AfterMapping
    public void dtoToEntity(AttributeDTO attributeDTO, @MappingTarget Attribute attribute) {
        attribute.setCategory(categoryService.getOne(attributeDTO.getCategoryId()));
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        AttributeMapper.categoryService = categoryService;
    }
}
