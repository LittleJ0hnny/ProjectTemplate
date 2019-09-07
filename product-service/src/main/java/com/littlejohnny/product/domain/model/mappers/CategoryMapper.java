package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public abstract class CategoryMapper {

    public abstract CategoryDTO entityToDto(Category category);

    public abstract Category dtoToEntity(CategoryDTO categoryDTO);
}
