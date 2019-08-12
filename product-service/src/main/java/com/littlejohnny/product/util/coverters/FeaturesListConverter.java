package com.littlejohnny.product.util.coverters;

import com.littlejohnny.product.domain.model.entity.ProductFeature;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class FeaturesListConverter implements AttributeConverter<List<ProductFeature>, String> {
    @Override
    public String convertToDatabaseColumn(List<ProductFeature> attribute) {
        return null;
    }

    @Override
    public List<ProductFeature> convertToEntityAttribute(String dbData) {
        return null;
    }
}
