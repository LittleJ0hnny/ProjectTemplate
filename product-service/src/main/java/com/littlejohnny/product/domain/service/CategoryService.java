package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.repository.CategoryRepository;

public interface CategoryService extends Service<Category, Long, CategoryRepository> {
}
