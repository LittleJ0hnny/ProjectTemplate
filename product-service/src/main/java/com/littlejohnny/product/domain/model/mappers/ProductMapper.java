package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.service.CategoryService;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import com.littlejohnny.product.domain.service.impl.CategoryServiceImpl;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public abstract class ProductMapper {

    private static CategoryService categoryService;

    private static ProductFeatureService productFeatureService;

    private static ProductFeatureMapper productFeatureMapper;


    public abstract ProductDTO entityToDto(Product product);

    public abstract Product dtoToEntity(ProductDTO productDTO);

    @AfterMapping
    public void dtoToEntity(ProductDTO productDTO, @MappingTarget Product product) {
        product.setCategory(categoryService.getOne(productDTO.getCategoryId()));
        product.setProductFeatures(productFeatureService.saveAll(productDTO.getProductFeatures()
                .stream()
                .map(e -> productFeatureMapper.dtoToEntity(e))
                .collect(Collectors.toList())));
    }


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        ProductMapper.categoryService = categoryService;
    }

    @Autowired
    public void setProductFeatureService(ProductFeatureService productFeatureService) {
        ProductMapper.productFeatureService = productFeatureService;
    }

    @Autowired
    public void setProductFeatureMapper(ProductFeatureMapper productFeatureMapper) {
        ProductMapper.productFeatureMapper = productFeatureMapper;
    }

}
