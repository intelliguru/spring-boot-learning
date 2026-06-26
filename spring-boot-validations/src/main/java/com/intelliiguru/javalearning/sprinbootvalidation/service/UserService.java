package com.intelliiguru.javalearning.sprinbootvalidation.service;

import com.intelliiguru.javalearning.sprinbootvalidation.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService() {

    }

    public String saveUserToDB(UserRequestDTO userRequestDTO) {
        return "Validation Successful!!! :) and Data saved to Database";
    }
}
