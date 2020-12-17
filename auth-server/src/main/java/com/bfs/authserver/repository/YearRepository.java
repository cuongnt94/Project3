package com.bfs.authserver.repository;

import domain.Timesheet;
import domain.Year;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface YearRepository extends MongoRepository<Year, String> {
    Optional<Year> findYearByYearId(String yearId);
    List<Year> findAllByEmpId(String empId);
    Year insert(Year year);
}
