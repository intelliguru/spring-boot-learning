package com.intelliguru.javalearning.beanscope.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExampleTest {
    @Autowired
    private RestTemplate restTemplate;
}
