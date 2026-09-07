package com.intelliguru.javalearning.paginationsorting.dto;

import lombok.Data;

@Data
public class EmployeeCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private double salary;
}