package com.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-15 <br>
 */
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class ContactApplication {

    public static void main(String[] args) {

        SpringApplication.run(ContactApplication.class, args);

    }
}
