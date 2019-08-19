package com.littlejohnny.order.domain.model.entity;

import com.littlejohnny.order.domain.model.dto.WishListDTO;
import com.littlejohnny.order.util.converters.ListOfIdsConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "wishes")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false,unique = true)
    private Long employeeId;

    @Convert(converter = ListOfIdsConverter.class)
    private List<Long> productIds;
}
