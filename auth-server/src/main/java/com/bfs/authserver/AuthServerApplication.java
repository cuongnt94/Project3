package com.bfs.authserver;

import com.bfs.authserver.repository.EmployeeRepository;
import domain.Address;
import domain.Contact;
import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServerApplication implements CommandLineRunner {
    @Autowired
    EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Employee e = new Employee();
        e.setEmpId("1");
        e.setUsername("Duncan");
        e.setPassword("1234");
        Address a = new Address("123 Sesame Street",
                "",
                "New York",
                "12345",
                "USA"
        );
        e.setAddress(a);
        Contact c = new Contact("123-456-7890",
                "Duncanxia@someplace.com",
                "Emergency1",
                "911-911-9999",
                "Emergency2",
                "911-911-9999");
        e.setContact(c);
        repository.save(e);

    }

}
