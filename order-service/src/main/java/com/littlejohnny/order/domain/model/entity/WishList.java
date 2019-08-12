package com.littlejohnny.order.domain.model.entity;

import com.littlejohnny.order.domain.model.dto.WishListDTO;
import com.littlejohnny.order.util.converters.ListToStringConverter;
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

    @Convert(converter = ListToStringConverter.class)
    private List<Long> productIds;

    public WishList(WishListDTO wishListDTO) {
        this.id = wishListDTO.getId();
        this.employeeId = wishListDTO.getEmployeeId();
        this.productIds = wishListDTO.getProductIds();
    }
}
