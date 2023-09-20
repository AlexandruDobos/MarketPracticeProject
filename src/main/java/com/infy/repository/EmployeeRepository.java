package com.infy.repository;

import com.infy.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    boolean existsByEmail(String email);
}
