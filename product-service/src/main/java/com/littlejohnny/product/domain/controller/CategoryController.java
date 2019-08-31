package com.littlejohnny.product.domain.controller;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.model.mappers.AttributeMapper;
import com.littlejohnny.product.domain.model.mappers.CategoryMapper;
import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Long ROOT_CATEGORY_ID = 1L;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(CategoryMapper.INSTANCE.dtoToEntity(categoryDTO));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return CategoryMapper.INSTANCE.entityToDto(categoryService.getOne(id));
    }

    @GetMapping
    public CategoryDTO getFullCategoryTree() {
        return CategoryMapper.INSTANCE.entityToDto(categoryService.getOne(ROOT_CATEGORY_ID));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/attributes")
    public ResponseEntity addCategoryAttributes(@PathVariable Long id, @RequestBody List<AttributeDTO> attributeDTOs) {
        Category category = categoryService.getOne(id);
        category.addAttributes(attributeDTOs.stream().map(AttributeMapper.INSTANCE::dtoToEntity).collect(Collectors.toList()));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @DeleteMapping("/{categoryId}/attributes/{attributeId}")
    public ResponseEntity deleteCategoryAttributes(@PathVariable Long categoryId, @PathVariable Long attributeId) {
        categoryService.getOne(categoryId).getAttributes().removeIf(e -> e.getId().equals(attributeId));
        return ResponseEntity.noContent().build();
    }
}
