package com.littlejohnny.operation.domain.service;

import com.littlejohnny.operation.domain.model.entity.Operation;
import com.littlejohnny.operation.domain.repository.OperationRepository;

public interface OperationService extends Service<Operation, Long, OperationRepository> {
}
