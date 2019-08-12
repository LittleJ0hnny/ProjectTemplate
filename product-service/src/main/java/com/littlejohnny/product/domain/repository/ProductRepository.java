package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
