package com.littlejohnny.product.domain.service.impl;

import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.repository.AttributeRepository;
import com.littlejohnny.product.domain.service.AbstractService;
import com.littlejohnny.product.domain.service.AttributeService;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl extends AbstractService<Attribute, Long, AttributeRepository> implements AttributeService {

    protected AttributeServiceImpl(AttributeRepository repository) {
        super(repository);
    }
}
