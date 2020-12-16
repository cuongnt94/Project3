package com.bfs.authserver.repository;

import domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.*;

public interface TimesheetRepository extends MongoRepository<Timesheet,String>{
    Optional<Timesheet> findTimesheetByTimesheetId(String timesheetId);
    List<Timesheet> findAllByEmpId(String empId);
    Timesheet findTimesheetByWeekEndDate(String weekEndDate);
    Timesheet insert(Timesheet timeSheet);
}
