package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.model.mappers.AttributeMapper;
import com.littlejohnny.product.domain.model.mappers.CategoryMapper;
import com.littlejohnny.product.domain.repository.CategoryRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.AttributeService;
import com.littlejohnny.product.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends AbstractService<Category, Long, CategoryRepository> implements CategoryService {

    private static final Long ROOT_CATEGORY_ID = 1L;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AttributeMapper attributeMapper;

    protected CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        save(categoryMapper.dtoToEntity(categoryDTO));
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        save(categoryMapper.dtoToEntity(categoryDTO));
    }

    @Override
    public CategoryDTO getRootCategory() {
        return categoryMapper.entityToDto(getOne(ROOT_CATEGORY_ID));
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryMapper.entityToDto(getOne(id));
    }

    @Override
    public void deleteCategoryById(Long id) {
        deleteById(id);
    }

    @Override
    public List<AttributeDTO> getCategoryAttributes(Long id) {
        return getOne(id).getAttributes().stream().map(e -> attributeMapper.entityToDto(e)).collect(Collectors.toList());
    }
}
