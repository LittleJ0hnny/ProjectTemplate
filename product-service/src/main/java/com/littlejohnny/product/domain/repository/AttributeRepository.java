package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    @Override
    List<Attribute> findAllById(Iterable<Long> ids);

    Attribute findByNameAndCategory(String name, Category category);
}
