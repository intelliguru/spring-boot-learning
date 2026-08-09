package com.intelliguru.javalearning.beanscope.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    private String orderId;
    private User user;
}
