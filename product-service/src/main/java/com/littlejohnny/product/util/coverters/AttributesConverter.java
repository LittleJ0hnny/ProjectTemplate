package com.littlejohnny.product.util.coverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.littlejohnny.product.domain.model.entity.AttributeValue;
import com.littlejohnny.product.util.MappersFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Converter
public class AttributesConverter implements AttributeConverter<List<AttributeValue>, String> {

    @Override
    public String convertToDatabaseColumn(List<AttributeValue> attributeValues) {
        String convertedAttributes = null;
        try {
            convertedAttributes = MappersFactory.getJSONMapper().writeValueAsString(attributeValues);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return convertedAttributes;
    }

    @Override
    public List<AttributeValue> convertToEntityAttribute(String dbData) {
        List<AttributeValue> attributeValues = null;
        try {
            attributeValues = MappersFactory.getJSONMapper().readValue(dbData, new TypeReference<List<AttributeValue>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributeValues;
    }
}
