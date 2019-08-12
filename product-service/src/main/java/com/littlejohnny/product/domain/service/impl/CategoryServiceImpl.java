package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.repository.CategoryRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends AbstractService<Category, Long, CategoryRepository> implements CategoryService {

    protected CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
