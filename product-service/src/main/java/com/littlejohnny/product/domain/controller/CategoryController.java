package com.littlejohnny.product.domain.controller;

import com.littlejohnny.product.domain.model.mappers.CategoryMapper;
import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Long ROOT_CATEGORY_ID = 1L;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return new CategoryDTO(categoryService.getOne(id));
    }

    @GetMapping
    public CategoryDTO getFullCategoryTree() {
        return CategoryMapper.INSTANCE.entityToDto(categoryService.getOne(ROOT_CATEGORY_ID));
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryDTO categoryDTO) {
        //
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
