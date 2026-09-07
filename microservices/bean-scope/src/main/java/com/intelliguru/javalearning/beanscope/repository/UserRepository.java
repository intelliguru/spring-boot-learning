package com.intelliguru.javalearning.beanscope.repository;

import com.intelliguru.javalearning.beanscope.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByusername(String userName);
}
