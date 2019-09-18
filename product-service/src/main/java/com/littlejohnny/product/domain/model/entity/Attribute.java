package com.littlejohnny.product.domain.model.entity;

import com.littlejohnny.product.util.coverters.ListOfExistValuesConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id) &&
                name.equals(attribute.name) &&
                category.getId().equals(attribute.category.getId()) &&
                category.getName().equals(attribute.category.getName()) &&
                Objects.equals(existingValues, attribute.existingValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, existingValues);
    }

    @Override
    public String toString() {
        String existingValues = this.existingValues == null ? "\"\"" : this.existingValues.toString();

        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category.getName() +
                ", existingValues=" + existingValues +
                '}';
    }
}
