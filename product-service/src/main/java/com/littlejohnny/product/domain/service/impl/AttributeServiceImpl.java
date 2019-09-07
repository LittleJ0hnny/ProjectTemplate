package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.dto.AttributeDTO;
import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.model.mappers.AttributeMapper;
import com.littlejohnny.product.domain.repository.AttributeRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void createAttribute(AttributeDTO attributeDTO) {
        save(attributeMapper.dtoToEntity(attributeDTO));
    }
}
