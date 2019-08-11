package com.littlejohnny.product.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "attribute_to_category")
public class CategoryAttributes {
    private Category category;

    private List<Attribute> attributes;
}
