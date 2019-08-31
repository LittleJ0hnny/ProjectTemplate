package com.littlejohnny.product.domain.model.mappers;

import com.littlejohnny.product.domain.model.dto.CategoryDTO;
import com.littlejohnny.product.domain.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring", uses = CustomAttributeMapper.class)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO entityToDto(Category category);

    Category dtoToEntity(CategoryDTO categoryDTO);
}
