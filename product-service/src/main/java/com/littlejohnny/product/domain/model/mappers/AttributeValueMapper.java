package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.AttributeValueDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.entity.AttributeValue;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.service.AttributeService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.Objects;

@Mapper(componentModel="spring")
public abstract class AttributeValueMapper {

    private static AttributeService attributeService;

    public AttributeValueDTO entityToDto(AttributeValue attributeValue) {
        AttributeValueDTO attributeValueDTO = new AttributeValueDTO();

        Attribute attribute = attributeService.findById(attributeValue.getAttributeId())
                .orElseThrow(() -> new EntityNotFoundException("Attribute with id " + attributeValue.getAttributeId() + " not exists"));
        attributeValueDTO.setAttributeName(attribute.getName());

        String value = attribute.getExistingValues().get(attributeValue.getAttributeValueId());

        if(Objects.isNull(value)) {
            throw new EntityNotFoundException("Attribute value with id " + attributeValue.getAttributeValueId() + " not exists");
        }

        attributeValueDTO.setAttributeValue(value);

        return attributeValueDTO;
    }

    public AttributeValue dtoToEntity(Category category, AttributeValueDTO attributeValueDTO) {
        if (category == null || attributeValueDTO == null) {
            return null;
        }

        Attribute attribute = attributeService.findByNameAndCategory(attributeValueDTO.getAttributeName(), category);

        if(Objects.isNull(attribute)) {
            throw new EntityNotFoundException("Attribute with name " + attributeValueDTO.getAttributeName() + " not exists under category with id " + category.getId());
        }

        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setAttributeId(attribute.getId());

        Long attributeValueId = null;
        for(Map.Entry<Long, String> entry : attribute.getExistingValues().entrySet()) {
            if(entry.getValue().equals(attributeValueDTO.getAttributeValue())) {
                attributeValueId = entry.getKey();
            }
        }

        if(Objects.isNull(attributeValueId)) {
            throw new EntityNotFoundException("Attribute value with id " + attributeValueId + " not exists");
        }

        attributeValue.setAttributeValueId(attributeValueId);

        return attributeValue;
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        AttributeValueMapper.attributeService = attributeService;
    }
}
