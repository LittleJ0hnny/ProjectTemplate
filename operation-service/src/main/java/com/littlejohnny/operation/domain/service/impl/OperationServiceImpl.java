package com.littlejohnny.operation.domain.service.impl;

import com.littlejohnny.operation.domain.model.entity.Operation;
import com.littlejohnny.operation.domain.repository.OperationRepository;
import com.littlejohnny.operation.domain.service.AbstractService;
import com.littlejohnny.operation.domain.service.OperationService;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl extends AbstractService<Operation, Long, OperationRepository> implements OperationService {

    protected OperationServiceImpl(OperationRepository repository) {
        super(repository);
    }
}
