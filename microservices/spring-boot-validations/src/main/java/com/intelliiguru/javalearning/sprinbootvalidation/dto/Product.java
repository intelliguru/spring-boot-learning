package com.intelliiguru.javalearning.sprinbootvalidation.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Product {
    private long id;
    private String productName;
    private String price;
}
