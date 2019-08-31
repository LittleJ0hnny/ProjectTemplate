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
}
