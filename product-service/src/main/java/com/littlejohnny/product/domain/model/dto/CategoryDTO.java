package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    private Long parentCategoryId;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentCategoryId = category.getParentCategory().getId();
    }
}
