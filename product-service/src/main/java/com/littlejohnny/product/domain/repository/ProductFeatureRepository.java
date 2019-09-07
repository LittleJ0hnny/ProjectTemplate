package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFeatureRepository extends JpaRepository<ProductFeature, Long> {

    List<ProductFeature> findAllByIdIn(List<Long> ids);

}
