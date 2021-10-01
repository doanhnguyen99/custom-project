package com.fabbi.news.service;

import com.fabbi.news.dto.ProductDTO;
import com.fabbi.news.entity.ProductEntity;

import java.util.Optional;

public interface IProductService {
    void addProduct(ProductDTO productDTO);
//    void updateProduct(ProductDTO productDTO);
    Optional<ProductEntity> findById(Long productId);

    ProductEntity update(ProductDTO productDTO);
}
