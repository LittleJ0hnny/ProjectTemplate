package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.repository.AttributeRepository;

import java.util.List;
import java.util.Map;

public interface AttributeService extends Service<Attribute, Long, AttributeRepository> {

    List<Attribute> findAllByIds(Iterable<Long> ids);

    Attribute findByNameAndCategory(String name, Category category);

    void addAttributes(List<AttributeDTO> attributeDTOs);

    void addAttribute(AttributeDTO attributeDTO);

    void updateAttributes(List<AttributeDTO> attributeDTOs);

    void updateAttribute(AttributeDTO attributeDTO);

    List<AttributeDTO> getAttributes();

    AttributeDTO getAttributeById(Long attributeId);

    void deleteAttributeById(Long attributeId);

    void createExistingAttributeValues(Long attributeId, List<String> attributeValues);

    void updateExistingAttributeValues(Long attributeId, Map<Long, String> attributeValues);

    void deleteExistingAttributeValue(Long attributeId, Long existingValueId);
}
