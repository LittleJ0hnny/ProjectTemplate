package com.littlejohnny.product.util.coverters;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Converter
public class ListOfStringsConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        StringBuilder arrayWithStrings = new StringBuilder("[");
        for(int i = 0; i < strings.size(); i++) {
            arrayWithStrings.append(strings.get(i));
            if(strings.size() - i > 1) arrayWithStrings.append(",");
        }
        return arrayWithStrings.append("]").toString();
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return parseString(dbData);
    }

    private List<String> parseString(String dbData) {
        return Arrays.stream(dbData.substring(1, dbData.length()-1).split(",")).collect(Collectors.toList());
    }
}
