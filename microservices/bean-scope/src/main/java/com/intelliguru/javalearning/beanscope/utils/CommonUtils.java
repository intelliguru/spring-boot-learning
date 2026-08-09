package com.intelliguru.javalearning.beanscope.utils;

import com.intelliguru.javalearning.beanscope.entity.User;
import tools.jackson.databind.ObjectMapper;

public class CommonUtils {
    private CommonUtils() {}

    ObjectMapper objectMapper = new ObjectMapper();

//    private void objectMapperExample() {
//        User user = new User(
//                1,
//                "Rahul",
//                "Delhi",
//                "Senior Lead Engineer",
//                26
//        );
//        String json = objectMapper.writeValueAsString(user);
//        // this converts Java object into JSON
//
//        User userDetails = objectMapper.readValue(json, User.class);
//        // this converts JSON into Java Object
//
//    }
}
