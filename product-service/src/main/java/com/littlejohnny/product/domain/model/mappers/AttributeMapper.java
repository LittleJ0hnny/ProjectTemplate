package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.service.AttributeService;
import com.littlejohnny.product.domain.service.CategoryService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class AttributeMapper {

    private static CategoryService categoryService;

    private static AttributeService attributeService;

    public abstract AttributeDTO entityToDto(Attribute attribute);

    public Attribute dtoToEntity(AttributeDTO attributeDTO) {
        if (attributeDTO == null) {
            return null;
        }

        Attribute attribute = attributeService.findById(attributeDTO.getId()).orElse(new Attribute());

        attribute.setName(attributeDTO.getName());
        attribute.setCategory(categoryService.getOne(attributeDTO.getCategoryId()));

        return attribute;
    }

    @AfterMapping
    public void entityToDto(Attribute attribute, @MappingTarget AttributeDTO attributeDTO) {
        attributeDTO.setCategoryId(attribute.getCategory().getId());
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        AttributeMapper.categoryService = categoryService;
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        AttributeMapper.attributeService = attributeService;
    }
}
