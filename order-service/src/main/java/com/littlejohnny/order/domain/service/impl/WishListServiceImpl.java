package com.littlejohnny.order.domain.service.impl;

import com.littlejohnny.order.domain.model.entity.WishList;
import com.littlejohnny.order.domain.repository.WishListRepository;
import com.littlejohnny.order.domain.service.AbstractService;
import com.littlejohnny.order.domain.service.WishListService;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl extends AbstractService<WishList, Long, WishListRepository> implements WishListService {

    protected WishListServiceImpl(WishListRepository repository) {
        super(repository);
    }
}
