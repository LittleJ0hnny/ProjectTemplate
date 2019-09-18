package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.entity.Category;
import com.littlejohnny.product.domain.model.mappers.AttributeMapper;
import com.littlejohnny.product.domain.repository.AttributeRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.AttributeService;
import com.littlejohnny.product.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl extends AbstractService<Attribute, Long, AttributeRepository> implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    protected AttributeServiceImpl(AttributeRepository repository) {
        super(repository);
    }

    @Override
    public List<Attribute> findAllByIds(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Attribute findByNameAndCategory(String name, Category category) {
        return repository.findByNameAndCategory(name, category);
    }


    @Override
    public void addAttributes(List<AttributeDTO> attributeDTOs) {
        saveAll(attributeDTOs.stream().map(e -> attributeMapper.dtoToEntity(e)).collect(Collectors.toList()));
    }

    @Override
    public void addAttribute(AttributeDTO attributeDTO) {
        save(attributeMapper.dtoToEntity(attributeDTO));
    }

    @Override
    public void updateAttributes(List<AttributeDTO> attributeDTOs) {
        saveAll(attributeDTOs.stream().map(e -> attributeMapper.dtoToEntity(e)).collect(Collectors.toList()));
    }

    @Override
    public void updateAttribute(AttributeDTO attributeDTO) {
        save(attributeMapper.dtoToEntity(attributeDTO));
    }

    @Override
    public List<AttributeDTO> getAttributes() {
        return findAll().stream().map(e -> attributeMapper.entityToDto(e)).collect(Collectors.toList());
    }

    @Override
    public AttributeDTO getAttributeById(Long attributeId) {
        return attributeMapper.entityToDto(getOne(attributeId));
    }

    @Override
    public void deleteAttributeById(Long attributeId) {
        deleteById(attributeId);
    }

    @Override
    public void createExistingAttributeValues(Long attributeId, List<String> attributeValues) {
        Attribute attribute = getOne(attributeId);
        addExistingValues(getOne(attributeId), attributeValues);
        save(attribute);
    }

    @Override
    public void updateExistingAttributeValues(Long attributeId, Map<Long, String> attributeValues) {
        Attribute attribute = getOne(attributeId);
        updateExistingValues(attribute, attributeValues);
        save(attribute);
    }

    @Override
    public void deleteExistingAttributeValue(Long attributeId, Long existingValueId) {
        Attribute attribute = getOne(attributeId);
        deleteExistingValue(attribute, existingValueId);
        save(attribute);
    }

    private void addExistingValues(Attribute attribute, List<String> values) {
        Map<Long, String> existingValues = attribute.getExistingValues();

        if(Objects.isNull(existingValues)) {
            existingValues = new HashMap<>();
        }

        for(String value : values) {
            if(value.isEmpty()) {
                throw new DataIntegrityViolationException("You can't set empty string as value");
            }

            if(existingValues.containsValue(value)) {
                throw new DataIntegrityViolationException("This attribute already contains value " + value + ".");
            }

            existingValues.put(nextId(existingValues), value);
        }

        attribute.setExistingValues(existingValues);
    }

    private void updateExistingValues(Attribute attribute, Map<Long, String> valuesToEdit) {
        Map<Long, String> existingValues = attribute.getExistingValues();

        for(Map.Entry<Long, String> entry : valuesToEdit.entrySet()) {
            if(entry.getValue().trim().isEmpty()) {
                throw new DataIntegrityViolationException("You can't set empty string as value");
            }

            if(!valuesToEdit.containsKey(entry.getKey())) {
                throw new DataIntegrityViolationException("This attribute has not value with id " + entry.getKey() + ".");
            }

            existingValues.put(entry.getKey(), entry.getValue());
        }
    }

    private void deleteExistingValue(Attribute attribute, Long existingValueId) {
        Map<Long, String> existingValues = attribute.getExistingValues();

        existingValues.remove(existingValueId);
    }

    private Long nextId(Map<Long, String> existingValues) {
        if(existingValues.isEmpty()) {
            return 0L;
        }

        long nextId = existingValues.keySet().stream().max(Long::compare).get();

        return nextId + 1L;
    }
}
