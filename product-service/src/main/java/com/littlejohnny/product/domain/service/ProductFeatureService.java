package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.repository.ProductFeatureRepository;

import java.util.List;

public interface ProductFeatureService extends Service<ProductFeature, Long, ProductFeatureRepository> {

    List<ProductFeature> findAllByIdIn(List<Long> ids);
}
