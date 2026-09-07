package com.intelliguru.javalearning.beanscope.mapper;

import com.intelliguru.javalearning.beanscope.entity.User;
import com.intelliguru.javalearning.beanscope.response.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toDTO(User user);
}