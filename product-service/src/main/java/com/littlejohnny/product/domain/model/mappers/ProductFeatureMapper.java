package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductFeatureDTO;
import com.littlejohnny.product.domain.model.entity.ProductFeature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductFeatureMapper {

    ProductFeatureMapper INSTANCE = Mappers.getMapper(ProductFeatureMapper.class);

    ProductFeatureDTO entityToDto(ProductFeature productFeature);

    ProductFeature dtoToEntity(ProductFeatureDTO productFeatureDTO);
}
