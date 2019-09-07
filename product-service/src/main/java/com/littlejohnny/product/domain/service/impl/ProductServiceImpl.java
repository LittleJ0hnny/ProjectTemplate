package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.dto.ProductFeatureDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.model.mappers.ProductFeatureMapper;
import com.littlejohnny.product.domain.model.mappers.ProductMapper;
import com.littlejohnny.product.domain.repository.ProductRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import com.littlejohnny.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long, ProductRepository> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    protected ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    public void createProduct(ProductDTO productDTO) {
        save(productMapper.dtoToEntity(productDTO));
    }
}
