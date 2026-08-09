package com.intelliguru.javalearning.beanscope.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password; // Dangerous if leaked
    private String role;    // Dangerous if modified by client

    private List<Order> orders;
}
