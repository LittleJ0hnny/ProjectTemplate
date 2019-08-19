package com.littlejohnny.operation.domain.model.mappers;

import com.littlejohnny.operation.domain.model.dto.OperationDTO;
import com.littlejohnny.operation.domain.model.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    OperationDTO entityToDto(Operation operation);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true)
    })
    Operation dtoToEntity(OperationDTO operationDTO);
}
