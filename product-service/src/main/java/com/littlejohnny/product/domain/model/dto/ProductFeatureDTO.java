package com.littlejohnny.product.domain.model.dto;

import com.littlejohnny.product.domain.model.entity.ProductFeature;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductFeatureDTO {

    private Long id;

    private String name;

    private String description;

    private String iconUrl;
}
