package com.littlejohnny.product.util.coverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

@Converter
public class MapToStringConverter implements AttributeConverter<Map<String, String>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        return "";
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        return new HashMap<>();
    }
}
