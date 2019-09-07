package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductFeatureDTO;
import com.littlejohnny.product.domain.model.entity.ProductFeature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public abstract class ProductFeatureMapper {

    public abstract ProductFeatureDTO entityToDto(ProductFeature productFeature);

    public abstract ProductFeature dtoToEntity(ProductFeatureDTO productFeatureDTO);

}
