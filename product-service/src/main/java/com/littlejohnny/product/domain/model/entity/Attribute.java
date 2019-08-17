package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.util.coverters.AttributesConverter;
import com.littlejohnny.product.util.coverters.ListOfStringsConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @Convert(converter = ListOfStringsConverter.class)
    private List<String> existingValues;
}
