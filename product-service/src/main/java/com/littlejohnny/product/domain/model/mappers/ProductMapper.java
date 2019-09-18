package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.service.CategoryService;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import com.littlejohnny.product.domain.service.impl.CategoryServiceImpl;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public abstract class ProductMapper {

    private static CategoryService categoryService;

    private static ProductFeatureService productFeatureService;

    private static ProductFeatureMapper productFeatureMapper;

    private static AttributeValueMapper attributeValueMapper;

    public abstract ProductDTO entityToDto(Product product);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true)
    })
    public abstract Product dtoToEntity(ProductDTO productDTO);

    @AfterMapping
    public void entityToDto(Product product, @MappingTarget ProductDTO productDTO) {
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setAttributeValueDTOs(product.getAttributeValues()
                .stream()
                .map(e -> attributeValueMapper.entityToDto(e))
                .collect(Collectors.toList()));
        productDTO.setProductFeatures(product.getProductFeatures()
                .stream()
                .map(e -> productFeatureMapper.entityToDto(e))
                .collect(Collectors.toList()));
    }

    @AfterMapping
    public void dtoToEntity(ProductDTO productDTO, @MappingTarget Product product) {
        Category category = categoryService.getOne(productDTO.getCategoryId());
        product.setCategory(category);
        product.setAttributeValues(productDTO.getAttributeValueDTOs()
                .stream()
                .map(e -> attributeValueMapper.dtoToEntity(category, e))
                .collect(Collectors.toList()));
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

    @Autowired
    public void setAttributeValueMapper(AttributeValueMapper attributeValueMapper) {
        ProductMapper.attributeValueMapper = attributeValueMapper;
    }

}
