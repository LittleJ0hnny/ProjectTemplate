package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    private Long parentId;

    private List<CategoryDTO> childCategories;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentId = category.getParentId();
        this.childCategories = category.getChildCategories().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }
}
