package com.littlejohnny.product.util.coverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.littlejohnny.product.util.MappersFactory;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Component
@Converter
public class ListOfExistValuesConverter implements AttributeConverter<Map<Long, String>, String> {

    @Override
    public String convertToDatabaseColumn(Map<Long, String> existingValues) {
        String convertedAttributes = null;
        try {
            convertedAttributes = MappersFactory.getJSONMapper().writeValueAsString(existingValues);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return convertedAttributes;
    }

    @Override
    public Map<Long, String> convertToEntityAttribute(String dbData) {
        Map<Long, String> attributes = null;
        try {
            attributes = MappersFactory.getJSONMapper().readValue(dbData, new TypeReference<Map<Long, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributes;
    }
}
