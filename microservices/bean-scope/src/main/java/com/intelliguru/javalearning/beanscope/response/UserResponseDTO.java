package com.intelliguru.javalearning.beanscope.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UserResponseDTO {
    Long id;
    String username;
}
