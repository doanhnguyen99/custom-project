package com.fabbi.news.api;

import com.fabbi.news.dto.ProductDTO;
import com.fabbi.news.entity.ProductEntity;
import com.fabbi.news.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ProductAPI {
    @Autowired
    IProductService productService;

    @PostMapping(value = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @PutMapping(value = "/update/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO){
        Optional<ProductEntity> productEntity = productService.findById(productId);
        if (productEntity.isPresent()){
            String dataCreatedBy = productEntity.get().getCreatedBy();
            productDTO.setCreatedBy(dataCreatedBy);
            Date dataCreateAt = productEntity.get().getCreatedDate();
            productDTO.setCreatedDate(dataCreateAt);
        }

        return productEntity.map(product -> {
            productDTO.setId(product.getId());
            return new ResponseEntity<>(productService.update(productDTO), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<ProductEntity> findById(@PathVariable Long productId){
        return productService.findById(productId);
    }

    @DeleteMapping("/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long productId){
        productService.delete(productId);
    }
}