package com.littlejohnny.product.util.coverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.littlejohnny.product.domain.model.dto.AttributeValueDTO;
import com.littlejohnny.product.util.MappersFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Converter
public class AttributesConverter implements AttributeConverter<List<AttributeValueDTO>, String> {

    @Override
    public String convertToDatabaseColumn(List<AttributeValueDTO> attributeValues) {
        String convertedAttributes = null;
        try {
            convertedAttributes = MappersFactory.getJSONMapper().writeValueAsString(attributeValues);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return convertedAttributes;
    }

    @Override
    public List<AttributeValueDTO> convertToEntityAttribute(String dbData) {
        List<AttributeValueDTO> attributeValueDTOS = null;
        try {
            attributeValueDTOS = MappersFactory.getJSONMapper().readValue(dbData, new TypeReference<List<AttributeValueDTO>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributeValueDTOS;
    }
}
