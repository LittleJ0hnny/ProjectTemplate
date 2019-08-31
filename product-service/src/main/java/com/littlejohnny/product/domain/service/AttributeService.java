package com.littlejohnny.product.domain.service;

import com.littlejohnny.product.domain.model.entity.Attribute;
import com.littlejohnny.product.domain.repository.AttributeRepository;

import java.util.List;

public interface AttributeService extends Service<Attribute, Long, AttributeRepository> {

    List<Attribute> findAllByIds(Iterable<Long> ids);
}
