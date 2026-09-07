package com.intelliguru.javalearning.paginationsorting.controller;

import com.intelliguru.javalearning.paginationsorting.dto.EmployeeCreateDto;
import com.intelliguru.javalearning.paginationsorting.dto.EmployeeResponseDto;
import com.intelliguru.javalearning.paginationsorting.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping
//    public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees (
//            @RequestParam int page,
//            @RequestParam int size
//    ) {
//        Page<EmployeeResponseDto> employees = employeeService.getEmployees(page, size);
//        return ResponseEntity.ok(employees);
//    }
//
    
    
    


























    @GetMapping
    public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployeesWithSortedData (
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String sortDir
    ) {
        Page<EmployeeResponseDto> employees = employeeService.getEmployees(page, size, sortBy, sortDir);
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeCreateDto requestDto) {
        EmployeeResponseDto savedEmployee = employeeService.saveEmployee(requestDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
