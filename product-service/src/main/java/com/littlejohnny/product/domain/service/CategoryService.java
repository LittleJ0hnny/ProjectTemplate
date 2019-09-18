package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.repository.CategoryRepository;

import java.util.List;
import java.util.Map;

public interface CategoryService extends Service<Category, Long, CategoryRepository> {

    void createCategory(CategoryDTO categoryDTO);

    void updateCategory(CategoryDTO categoryDTO);

    CategoryDTO getRootCategory();

    CategoryDTO getCategoryById(Long id);

    void deleteCategoryById(Long id);

    List<AttributeDTO> getCategoryAttributes(Long id);
}
