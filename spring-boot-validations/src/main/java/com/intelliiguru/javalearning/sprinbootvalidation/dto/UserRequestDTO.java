package com.intelliiguru.javalearning.sprinbootvalidation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotEmpty
    private String department;

    @NotBlank
    private String location;



    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @Min(18) @Max(60)
    private int age;
    @Valid
    private UserAddressDTO userAddress;

    @NotBlank
    // Enforces a standard 10-digit US phone format: 123-456-7890
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$")
    private String phoneNumber;


}

