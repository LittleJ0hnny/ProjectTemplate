package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.repository.AttributeRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.AttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl extends AbstractService<Attribute, Long, AttributeRepository> implements AttributeService {

    protected AttributeServiceImpl(AttributeRepository repository) {
        super(repository);
    }

    @Override
    public List<Attribute> findAllByIds(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }
}
