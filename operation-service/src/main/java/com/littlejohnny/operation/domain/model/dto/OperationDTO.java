package com.littlejohnny.operation.domain.model.dto;

import com.littlejohnny.operation.domain.model.entity.Operation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OperationDTO {
    private Long id;

    private String info;

    private LocalDateTime creationTime;

    public OperationDTO(Operation operation) {
        this.id = operation.getId();
        this.info = operation.getInfo();
        this.creationTime = operation.getCreationTime();
    }
}
