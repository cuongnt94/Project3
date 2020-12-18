package com.bfs.authserver.service;
import com.bfs.authserver.repository.*;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class DataAccessService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    YearRepository yearRepository;
    public Optional<Employee> findEmployeeByUsername(String username){
        return employeeRepository.findEmployeeByUsername((username));
    }
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
   public Employee insertEmployee(Employee e){
        employeeRepository.insert(e);
        return e;
    }
    public Optional<Timesheet> findTimesheetById(String id){
        return timesheetRepository.findTimesheetByTimesheetId(id);
    }
    public List<Timesheet> findTimesheetByEmpId(String empId){
        return timesheetRepository.findAllByEmpId(empId);
    }
    public Timesheet insertTimesheet(String empId, LocalDate currentDate){
        Timesheet t = new Timesheet(empId, LocalDate.now().with(TemporalAdjusters.previous( DayOfWeek.SUNDAY )));
        timesheetRepository.insert(t);
        return t;
    }
    public Timesheet findTimesheetByWeekEndDate(String weekEndDate){
        return timesheetRepository.findTimesheetByWeekEndDate(weekEndDate);
    }
    public Optional<Year> findYearById(String id){
        return yearRepository.findYearByYearId(id);
    }
    public List<Year> findYearByEmpId(String empId){
        return yearRepository.findAllByEmpId(empId);
    }
    public Year insertYear(String empId, String year){
        Year y = new Year(empId,year);
        yearRepository.insert(y);
        return y;
    }
    public void saveTimesheet(Timesheet timesheet){
        timesheetRepository.save(timesheet);
    }
}
