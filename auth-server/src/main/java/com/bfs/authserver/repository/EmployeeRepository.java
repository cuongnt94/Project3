package com.bfs.authserver.repository;

import domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String>, QuerydslPredicateExecutor<Employee> {
    Optional<Employee> findEmployeeByUsername(String username);
}
