package com.bfs.authserver.repository;

import domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.*;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findEmployeeByUsername(String username);
    List<Employee> findAll();
    Employee insert(Employee employee);
}
