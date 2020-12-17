package com.timesheet.dao.repository;

import com.timesheet.dao.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.*;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findEmployeeByUsername(String username);
    List<Employee> findAll();
    Employee insert(Employee employee);
    Optional<Employee> findEmployeeById(int id);
}
