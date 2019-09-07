package com.littlejohnny.product.domain.controller;

import com.littlejohnny.product.domain.model.dto.AttributeValueDTO;
import com.littlejohnny.product.domain.model.dto.ProductDTO;
import com.littlejohnny.product.domain.model.dto.ProductFeatureDTO;
import com.littlejohnny.product.domain.model.entity.Product;
import com.littlejohnny.product.domain.model.entity.ProductFeature;
import com.littlejohnny.product.domain.model.mappers.ProductFeatureMapper;
import com.littlejohnny.product.domain.model.mappers.ProductMapper;
import com.littlejohnny.product.domain.service.ProductFeatureService;
import com.littlejohnny.product.domain.service.ProductService;
import com.littlejohnny.utills.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity createProduct() {
        AttributeValueDTO attributeValueDTO = new AttributeValueDTO();
        attributeValueDTO.setAttributeId(0L);
        attributeValueDTO.setAttributeValueId(0L);
        AttributeValueDTO attributeValueDTO1 = new AttributeValueDTO();
        attributeValueDTO1.setAttributeId(1L);
        attributeValueDTO1.setAttributeValueId(1L);
        ProductFeatureDTO productFeatureDTO = new ProductFeatureDTO();
        productFeatureDTO.setName("ProductFeature1");
        productFeatureDTO.setDescription("Description");
        productFeatureDTO.setIconUrl("<iconUrl>");
        ProductFeatureDTO productFeatureDTO2 = new ProductFeatureDTO();
        productFeatureDTO2.setName("ProductFeature2");
        productFeatureDTO2.setDescription("Descriptio2");
        productFeatureDTO2.setIconUrl("<iconUr2>");
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Чебурек");
        productDTO.setPrice(300);
        productDTO.setCategoryId(19L);
        productDTO.setDescription("Description");
        productDTO.setImageUrls(Arrays.asList("<link1>", "<link2>", "<link3>"));
        productDTO.setAttributeValues(Arrays.asList(attributeValueDTO, attributeValueDTO1));
        productDTO.setProductFeatures(Arrays.asList(productFeatureDTO, productFeatureDTO2));
        productDTO.setRating(5);
        productDTO.setSellerId(2L);
        productDTO.setStockpile(50);
        productDTO.setCreationTime(DateTimeUtil.currentTime());

        productService.createProduct(productDTO);
        return ResponseEntity.created(URI.create("url")).build();
    }

}
