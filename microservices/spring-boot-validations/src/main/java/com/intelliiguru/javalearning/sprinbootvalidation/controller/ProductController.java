package com.intelliiguru.javalearning.sprinbootvalidation.controller;

import com.intelliiguru.javalearning.sprinbootvalidation.dto.Product;
import com.intelliiguru.javalearning.sprinbootvalidation.exception.ProductNotFoundException;
import com.intelliiguru.javalearning.sprinbootvalidation.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){

        return productService.getProduct(id);

    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());

    }
}
