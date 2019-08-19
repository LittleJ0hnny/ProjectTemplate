package com.littlejohnny.operation.domain.controller;

import com.littlejohnny.operation.domain.model.dto.OperationDTO;
import com.littlejohnny.operation.domain.model.mappers.OperationMapper;
import com.littlejohnny.operation.domain.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping
    public ResponseEntity createOperationRecord(@RequestBody OperationDTO operationDTO) {
        operationService.save(OperationMapper.INSTANCE.dtoToEntity(operationDTO));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping
    public List<OperationDTO> getAllOperationRecords() {
        return operationService.findAll()
                .stream()
                .map(OperationMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OperationDTO getOperationRecords(@PathVariable Long id) {
        return OperationMapper.INSTANCE.entityToDto(operationService.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOperationRecord(@PathVariable Long id) {
        operationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

