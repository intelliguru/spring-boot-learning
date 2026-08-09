package com.intelliiguru.javalearning.sprinbootvalidation.dto;

import com.intelliiguru.javalearning.sprinbootvalidation.util.validation.CreateUserGroup;
import com.intelliiguru.javalearning.sprinbootvalidation.util.validation.UpdateUserGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserDTO {
    @NotBlank(groups = {CreateUserGroup.class, UpdateUserGroup.class}, message = "Name is required")
    private String name;

    @NotBlank(groups = {CreateUserGroup.class, UpdateUserGroup.class}, message = "Email is required")
    @Email(groups = {CreateUserGroup.class, UpdateUserGroup.class}, message = "Invalid email format")
    private String email;

    @NotBlank(groups = CreateUserGroup.class, message = "Password is required during user creation")
    private String password;

}
