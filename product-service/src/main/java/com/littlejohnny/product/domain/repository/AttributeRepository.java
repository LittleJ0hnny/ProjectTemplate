package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
