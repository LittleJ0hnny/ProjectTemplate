package com.littlejohnny.product.domain.controller;

import com.littlejohnny.product.domain.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public ResponseEntity createAttribute() {

        return ResponseEntity.created(URI.create("url")).build();
    }


}
