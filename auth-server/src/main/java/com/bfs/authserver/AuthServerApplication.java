package com.bfs.authserver;

import com.bfs.authserver.service.DataAccessService;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class AuthServerApplication implements CommandLineRunner {
    @Autowired
    DataAccessService dataAccessService;

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
          LocalDate.now();
          List<Employee> e= dataAccessService.findAllEmployees();
          //dataAccessService.insertTimesheet("3",LocalDate.now());
          List<Timesheet> timesheets = dataAccessService.findTimesheetByEmpId("3");
         // dataAccessService.insertYear("3","2020");
          List<Year> years = dataAccessService.findYearByEmpId("3");
    }

}
