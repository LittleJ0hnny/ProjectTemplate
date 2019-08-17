package com.littlejohnny.product.util.coverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.littlejohnny.product.util.MappersFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter
public class AttributesConverter implements AttributeConverter<Map<String, String>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String, String> attributes) {
        String convertedAttributes = null;
        try {
            convertedAttributes = MappersFactory.getJSONMapper().writeValueAsString(attributes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return convertedAttributes;
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        Map<String, String> attributes = null;
        try {
            attributes = MappersFactory.getJSONMapper().readValue(dbData, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributes;
    }
}
