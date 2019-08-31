package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.Attribute;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class AttributeDTO {

    private Long id;

    private String name;

    private Map<Long, String> existingValues;

    private Long categoryId;
}
