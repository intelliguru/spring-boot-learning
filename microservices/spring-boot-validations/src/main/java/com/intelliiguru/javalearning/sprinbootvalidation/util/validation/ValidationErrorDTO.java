package com.intelliiguru.javalearning.sprinbootvalidation.util.validation;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ValidationErrorDTO {
    private String errorMessage;
    private String errorLocation;
}
