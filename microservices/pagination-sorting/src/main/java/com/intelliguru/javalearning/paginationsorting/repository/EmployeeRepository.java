package com.intelliguru.javalearning.paginationsorting.repository;

import com.intelliguru.javalearning.paginationsorting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
