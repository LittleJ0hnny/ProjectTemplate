package com.littlejohnny.order.util.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class ListOfIdsConverter implements AttributeConverter<List<Long>, String> {

    @Override
    public String convertToDatabaseColumn(List<Long> strings) {
        StringBuilder arrayWithStrings = new StringBuilder("[");
        for(int i = 0; i < strings.size(); i++) {
            arrayWithStrings.append(strings.get(i));
            if(strings.size() - i > 1) arrayWithStrings.append(",");
        }
        return arrayWithStrings.append("]").toString();
    }

    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        return parseString(dbData);
    }

    private List<Long> parseString(String dbData) {
        return Arrays.stream(dbData.substring(1, dbData.length()-1).split(",")).map(Long::valueOf).collect(Collectors.toList());
    }
}
