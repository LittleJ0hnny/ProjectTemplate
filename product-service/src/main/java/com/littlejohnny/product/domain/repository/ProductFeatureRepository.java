package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductFeatureRepository extends JpaRepository<ProductFeature, Long> {

    List<ProductFeature> findAllByIdIn(List<Long> ids);
}
