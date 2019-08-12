package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.repository.ProductFeatureRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProductFeatureServiceImpl extends AbstractService<ProductFeature, Long, ProductFeatureRepository> {

    protected ProductFeatureServiceImpl(ProductFeatureRepository repository) {
        super(repository);
    }
}
