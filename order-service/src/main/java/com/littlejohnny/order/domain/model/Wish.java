package com.littlejohnny.order.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wishes")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
