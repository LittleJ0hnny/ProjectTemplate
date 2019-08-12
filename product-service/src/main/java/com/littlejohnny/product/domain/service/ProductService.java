package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.repository.ProductRepository;

public interface ProductService extends Service<Product, Long, ProductRepository> {
}
