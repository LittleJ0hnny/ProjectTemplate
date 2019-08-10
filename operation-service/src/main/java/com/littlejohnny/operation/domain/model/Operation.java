package com.littlejohnny.operation.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
