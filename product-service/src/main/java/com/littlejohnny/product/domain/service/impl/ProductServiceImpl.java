package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.repository.ProductRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long, ProductRepository> implements ProductService {

    protected ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
