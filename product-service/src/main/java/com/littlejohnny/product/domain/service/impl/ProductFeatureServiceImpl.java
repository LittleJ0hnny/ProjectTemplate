package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.repository.ProductFeatureRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProductFeatureServiceImpl extends AbstractService<ProductFeature, Long, ProductFeatureRepository> implements ProductFeatureService {

    protected ProductFeatureServiceImpl(ProductFeatureRepository repository) {
        super(repository);
    }

    @Override
    public List<ProductFeature> findAllByIdIn(List<Long> ids) {
        return repository.findAllByIdIn(ids);
    }
}
