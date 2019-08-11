package com.littlejohnny.operation.domain.repository;

import com.littlejohnny.operation.domain.model.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
