package com.littlejohnny.order.domain.model.dto;

import com.littlejohnny.order.domain.model.entity.WishList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WishListDTO {

    private Long id;

    private Long employeeId;

    private List<Long> productIds;

    public WishListDTO(WishList wishList) {
        this.id = wishList.getId();
        this.employeeId = wishList.getEmployeeId();
        this.productIds = wishList.getProductIds();
    }
}
