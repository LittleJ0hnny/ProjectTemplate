package com.littlejohnny.order.domain.controller;

import com.littlejohnny.order.domain.model.dto.WishListDTO;
import com.littlejohnny.order.domain.model.mappers.WishListMapper;
import com.littlejohnny.order.domain.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wishes")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping
    public ResponseEntity createWishList(@RequestBody WishListDTO wishListDTO) {
        wishListService.save(WishListMapper.INSTANCE.dtoToEntity(wishListDTO));
        return ResponseEntity.created(URI.create("url")).build();
    }

    @GetMapping("/{id}")
    public WishListDTO getWishListById(@PathVariable Long id) {
        return WishListMapper.INSTANCE.entityToDto(wishListService.getOne(id));
    }

    @GetMapping
    public List<WishListDTO> getWishLists() {
        return wishListService.findAll().stream().map(WishListMapper.INSTANCE::entityToDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWishListById(@PathVariable Long id) {
        wishListService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
