package com.intelliiguru.javalearning.sprinbootvalidation.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
