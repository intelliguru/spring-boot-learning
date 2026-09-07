package com.intelliiguru.javalearning.sprinbootvalidation.controller;

import com.intelliiguru.javalearning.sprinbootvalidation.dto.UserDTO;
import com.intelliiguru.javalearning.sprinbootvalidation.dto.UserRequestDTO;
import com.intelliiguru.javalearning.sprinbootvalidation.service.UserService;
import com.intelliiguru.javalearning.sprinbootvalidation.util.validation.CreateUserGroup;
import com.intelliiguru.javalearning.sprinbootvalidation.util.validation.UpdateUserGroup;
import com.intelliiguru.javalearning.sprinbootvalidation.util.validation.ValidatorUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
private final ValidatorUtil validatorUtil;

    @PostMapping
    public String create(@Valid @RequestBody UserRequestDTO dto){
        // Business logic call
        return userService.saveUserToDB(dto);
    }


    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@Validated(CreateUserGroup.class) @RequestBody UserDTO userDto) {

        // Business logic call
        return ResponseEntity.ok("User Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Validated(UpdateUserGroup.class) @RequestBody UserDTO userDto) {

        // Business logic call
        return ResponseEntity.ok("User Updated");
    }










    // Validate using Validator and ConstraintViolation manually
//    @PostMapping
//    public String create(@RequestBody UserRequestDTO dto){
//        // Business logic call
//        boolean isValidationSuccessful = validatorUtil.validateUser(dto);
//        if(isValidationSuccessful) {
//            return userService.saveUserToDB(dto);
//        }
//        return "Validation Failed ):";
//    }

}
