package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.util.coverters.AttributesConverter;
import com.littlejohnny.product.util.coverters.ListOfExistValuesConverter;
import com.littlejohnny.product.util.coverters.ListOfStringsConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

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

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Convert(converter = ListOfExistValuesConverter.class)
    private Map<Long, String> existingValues;

    public void addExistingValue(String value) {
        if(Objects.isNull(existingValues)) {
            existingValues = new HashMap<>();
        }

        long nextId = nextId(existingValues);

        existingValues.put(nextId, value);
    }

    private Long nextId(Map<Long, String> existingValues) {
        long nextId = existingValues.keySet()
                .stream()
                .sorted()
                .max(Long::compare).orElse(0L);

        return nextId == 0L ? nextId : nextId + 1L;
    }
}
