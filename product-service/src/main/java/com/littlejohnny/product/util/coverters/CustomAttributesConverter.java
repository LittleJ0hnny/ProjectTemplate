package com.littlejohnny.product.util.coverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.littlejohnny.product.util.MappersFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter
public class CustomAttributesConverter implements AttributeConverter<Map<String, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, String> customAttributeValues) {
        String convertedAttributes = null;
        try {
            convertedAttributes = MappersFactory.getJSONMapper().writeValueAsString(customAttributeValues);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return convertedAttributes;
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        Map<String, String> customAttributeValues = null;
        try {
            customAttributeValues = MappersFactory.getJSONMapper().readValue(dbData, new TypeReference<Map<Long, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customAttributeValues;
    }
}
