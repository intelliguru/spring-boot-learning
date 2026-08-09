package com.intelliguru.javalearning.beanscope.controller;

import com.intelliguru.javalearning.beanscope.entity.User;
import com.intelliguru.javalearning.beanscope.exception.UserNotFoundException;
import com.intelliguru.javalearning.beanscope.response.UserResponseDTO;
import com.intelliguru.javalearning.beanscope.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int id) throws UserNotFoundException {
        UserResponseDTO userData = userService.getByUserId(id);
        return ResponseEntity.ok(userData);
    }























    @GetMapping("/")
    public ResponseEntity<List<User>> getUser() {
        List<User> userData = userService.findAll();
        return ResponseEntity.ok(userData);
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
