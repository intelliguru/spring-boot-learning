package com.intelliiguru.javalearning.sprinbootvalidation.service;

import com.intelliiguru.javalearning.sprinbootvalidation.dto.Product;
import com.intelliiguru.javalearning.sprinbootvalidation.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductService(){}

    public Product getProduct(Long id){

        throw new ProductNotFoundException("Product not found for Id = %s".formatted(id));

    }
}
