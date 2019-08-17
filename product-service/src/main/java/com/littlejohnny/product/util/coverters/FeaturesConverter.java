package com.littlejohnny.product.util.coverters;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class FeaturesConverter implements AttributeConverter<List<ProductFeature>, String> {

    @Autowired
    private ProductFeatureService productFeatureService;

    @Override
    public String convertToDatabaseColumn(List<ProductFeature> productFeatures) {
        StringBuilder arrayWithIds = new StringBuilder("[");
        for(int i = 0; i < productFeatures.size(); i++) {
            arrayWithIds.append(productFeatures.get(i).getId());
            if(productFeatures.size() - i > 1) arrayWithIds.append(",");
        }
        return arrayWithIds.append("]").toString();
    }

    @Override
    public List<ProductFeature> convertToEntityAttribute(String dbData) {
        return productFeatureService.findAllByIdIn(getIdsFromString(dbData));
    }

    private List<Long> getIdsFromString(String dbData) {
        return Arrays.stream(dbData.substring(1, dbData.length()-1).split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }
}
