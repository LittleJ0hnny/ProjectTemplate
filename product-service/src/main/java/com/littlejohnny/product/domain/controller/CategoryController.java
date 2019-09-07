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

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/root")
    public CategoryDTO getFullCategoryTree() {
        return categoryService.getRootCategory();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/attributes")
    public ResponseEntity addCategoryAttributes(@PathVariable Long id, @RequestBody List<AttributeDTO> attributeDTOs) {
        categoryService.addAttributes(id, attributeDTOs);
        return ResponseEntity.created(URI.create("url")).build();
    }

    @DeleteMapping("/{categoryId}/attributes/{attributeId}")
    public ResponseEntity deleteCategoryAttributes(@PathVariable Long categoryId, @PathVariable Long attributeId) {
        categoryService.deleteAttribute(categoryId, attributeId);
        return ResponseEntity.noContent().build();
    }
}
