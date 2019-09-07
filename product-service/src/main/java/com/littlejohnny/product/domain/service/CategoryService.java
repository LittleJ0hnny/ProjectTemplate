package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.repository.CategoryRepository;

import java.util.List;

public interface CategoryService extends Service<Category, Long, CategoryRepository> {

    void createCategory(CategoryDTO categoryDTO);

    CategoryDTO getRootCategory();

    CategoryDTO getCategoryById(Long id);

    void deleteCategoryById(Long id);

    void addAttributes(Long id, List<AttributeDTO> attributeDTOs);

    void deleteAttribute(Long categoryId, Long attributeId);
}
