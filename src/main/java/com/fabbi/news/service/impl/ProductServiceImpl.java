package com.fabbi.news.service.impl;

import com.fabbi.news.dto.ProductDTO;
import com.fabbi.news.entity.ProductEntity;
import com.fabbi.news.repository.ProductRepository;
import com.fabbi.news.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addProduct(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productRepository.save(productEntity);
    }

    @Override
    public Optional<ProductEntity> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public ProductEntity update(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity = modelMapper.map(productDTO, ProductEntity.class);
        return productRepository.save(productEntity);
    }
}
