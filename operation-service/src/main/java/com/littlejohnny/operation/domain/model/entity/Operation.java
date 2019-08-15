package com.littlejohnny.operation.domain.model.entity;

import com.littlejohnny.operation.domain.model.dto.OperationDTO;
import com.littlejohnny.utills.DateTimeUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "operations")
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String info;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;

    public Operation(OperationDTO operationDTO) {
        this.info = operationDTO.getInfo();
        this.creationTime = DateTimeUtil.currentTime();
    }
}
