package com.timesheet;

import com.timesheet.dao.domain.Employee;
import com.timesheet.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Optional;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-14 <br>
 */
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class TimesheetApplication implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {

        SpringApplication.run(TimesheetApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        Optional<Employee> e = employeeRepository.findEmployeeByUsername("Duncanxia@gmail.com");

    }
}
