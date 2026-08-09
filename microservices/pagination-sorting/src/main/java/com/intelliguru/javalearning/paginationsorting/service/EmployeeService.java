package com.intelliguru.javalearning.paginationsorting.service;

import com.intelliguru.javalearning.paginationsorting.dto.EmployeeCreateDto;
import com.intelliguru.javalearning.paginationsorting.entity.Employee;
import com.intelliguru.javalearning.paginationsorting.repository.EmployeeRepository;
import com.intelliguru.javalearning.paginationsorting.dto.EmployeeResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    public Page<EmployeeResponseDto> getEmployees(int page, int size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//
//        Page<Employee> employeePage = employeeRepository.findAll(pageable);
//
//        return employeePage.map(this::convertToDto);
//    }























        public Page<EmployeeResponseDto> getEmployees(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        return employeePage.map(this::convertToDto);
    }














    private EmployeeResponseDto convertToDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setFullName(employee.getFirstName() + " " + employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }

    public EmployeeResponseDto saveEmployee(EmployeeCreateDto createDto) {
        Employee employee = new Employee();
        employee.setFirstName(createDto.getFirstName());
        employee.setLastName(createDto.getLastName());
        employee.setEmail(createDto.getEmail());
        employee.setDepartment(createDto.getDepartment());
        employee.setSalary(createDto.getSalary());

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToDto1(savedEmployee);
    }

    private EmployeeResponseDto convertToDto1(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setFullName(employee.getFirstName() + " " + employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }


}