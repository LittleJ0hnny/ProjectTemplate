package com.littlejohnny.operation.domain.controller;

import com.littlejohnny.operation.domain.model.dto.OperationDTO;
import com.littlejohnny.operation.domain.model.entity.Operation;
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
    public ResponseEntity createOperationRecord(OperationDTO operationDTO) {
        operationService.save(new Operation(operationDTO));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping
    public List<OperationDTO> getOperations() {
        return operationService.findAll()
                .stream()
                .map(OperationDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OperationDTO getOperation(@PathVariable Long id) {
        return new OperationDTO(operationService.getOne(id));
    }
}
