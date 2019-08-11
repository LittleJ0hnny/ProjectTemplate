package com.littlejohnny.order.domain.repository;

import com.littlejohnny.order.domain.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
