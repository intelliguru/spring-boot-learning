package com.intelliguru.javalearning.beanscope.service.user;

import com.intelliguru.javalearning.beanscope.entity.User;
import com.intelliguru.javalearning.beanscope.exception.UserNotFoundException;
import com.intelliguru.javalearning.beanscope.repository.UserRepository;
import com.intelliguru.javalearning.beanscope.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO getByUserId(long id) throws UserNotFoundException {
        Optional<User> userData = userRepository.findById(id);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        if (userData.isPresent()) {
            User user = userData.get();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setUsername(user.getUsername());

            return userResponseDTO;
        }

        throw new UserNotFoundException("No user data found with given Id = %s".formatted(id));

    }


//    public User getByUserId(long id) {
//
//        Optional<User> user = userRepository.findById(id);
//        User userData = null;
//        if (user.isPresent()) {
//            userData = user.get();
//        }
//
//        return userData;
//    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User updateUser(User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(updatedUser.getId());

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update fields
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());

            // Save updated entity
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id " + updatedUser.getId());
        }
    }
}
