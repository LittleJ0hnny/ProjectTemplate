package com.littlejohnny.order.util.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class ListToStringConverter implements AttributeConverter<List<Object>, String> {

    @Override
    public String convertToDatabaseColumn(List<Object> attribute) {
        return "";
    }

    @Override
    public List<Object> convertToEntityAttribute(String dbData) {
        return new ArrayList<>();
    }
}
