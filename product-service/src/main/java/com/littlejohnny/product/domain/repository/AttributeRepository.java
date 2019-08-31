package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    @Override
    List<Attribute> findAllById(Iterable<Long> ids);
}
