package com.littlejohnny.product.domain.controller;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public ResponseEntity addAttributes(@RequestBody List<AttributeDTO> attributeDTOs) {
        attributeService.addAttributes(attributeDTOs);
        return ResponseEntity.created(URI.create("url")).build();
    }

    @PutMapping
    public ResponseEntity updateAttributes(@RequestBody List<AttributeDTO> attributeDTOs) {
        attributeService.updateAttributes(attributeDTOs);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{attributeId}")
    public AttributeDTO getAttributeById(@PathVariable Long attributeId) {
        return attributeService.getAttributeById(attributeId);
    }

    @DeleteMapping("/{attributeId}")
    public ResponseEntity deleteAttributeById(@PathVariable Long attributeId) {
        attributeService.deleteAttributeById(attributeId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{attributeId}/values")
    public ResponseEntity createExistingValues(@PathVariable Long attributeId, @RequestBody List<String> attributeValues) {
        attributeService.createExistingAttributeValues(attributeId, attributeValues);
        return ResponseEntity.created(URI.create("url")).build();
    }

    @PutMapping("/{attributeId}/values")
    public ResponseEntity updateExistingAttributeValues(@PathVariable Long attributeId, @RequestBody Map<Long, String> attributeValues) {
        attributeService.updateExistingAttributeValues(attributeId, attributeValues);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{attributeId}/values/{existingValueId}")
    public ResponseEntity deleteExistingValue(@PathVariable Long attributeId, @PathVariable Long existingValueId) {
        attributeService.deleteExistingAttributeValue(attributeId, existingValueId);
        return ResponseEntity.noContent().build();
    }
}
