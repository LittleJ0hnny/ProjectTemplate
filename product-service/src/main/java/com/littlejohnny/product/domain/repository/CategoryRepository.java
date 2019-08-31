package com.littlejohnny.product.domain.repository;

import com.littlejohnny.product.domain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteById(Long id);
}
