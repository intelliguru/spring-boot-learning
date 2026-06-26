package com.intelliiguru.javalearning.sprinbootvalidation.util.validation;

import com.intelliiguru.javalearning.sprinbootvalidation.dto.UserRequestDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class ValidatorUtil {
    private final Validator validator;

    public boolean validateUser(UserRequestDTO userDTO) {
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userDTO);

        if(!violations.isEmpty()) {
            for (ConstraintViolation<UserRequestDTO> violation : violations) {
                log.info("Validation Error Message: {}, Validation Error Path: {}",
                        violation.getMessage(), violation.getPropertyPath());
            }
        }
        return violations.isEmpty();
    }
}
