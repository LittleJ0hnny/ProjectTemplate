package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.Attribute;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AttributeDTO {

    private Long id;

    private String name;

    private List<String> existingValues;

    private Long categoryId;

    public AttributeDTO(Attribute attribute) {
        this.id = attribute.getId();
        this.name = attribute.getName();
        this.existingValues = attribute.getExistingValues();
        this.categoryId = attribute.getCategory().getId();
    }
}
