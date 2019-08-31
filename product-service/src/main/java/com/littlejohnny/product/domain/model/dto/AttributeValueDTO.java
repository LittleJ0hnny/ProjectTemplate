package com.littlejohnny.product.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttributeValueDTO {

    private Long id;

    private String name;

    private Long valueId;
}
