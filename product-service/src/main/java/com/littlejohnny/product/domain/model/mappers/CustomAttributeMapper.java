package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.service.CategoryService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel="spring")
public class CustomAttributeMapper {

    @Autowired
    private CategoryService categoryService;

    @AfterMapping
    public void dtoToEntity(AttributeDTO attributeDTO, @MappingTarget Attribute attribute) {
        attribute.setCategory(categoryService.getOne(attributeDTO.getCategoryId()));
    }

    @AfterMapping
    public void entityToDto(Attribute attribute, @MappingTarget AttributeDTO attributeDTO) {
        attributeDTO.setCategoryId(attribute.getCategory().getId());
    }

}
