package com.bfs.authserver.controller;


import com.bfs.authserver.repository.EmployeeRepository;
import com.bfs.authserver.security.CookieUtil;
import com.bfs.authserver.security.JwtUtil;
import domain.Address;
import domain.Contact;
import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private static final Map<String, String> credentials = new HashMap<>();


    public LoginController() {
        //credentials.put("admin@admin.com", "admin");
    }
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/login")
    public String login(){
      //  Optional<Employee> e = employeeRepository.findEmployeeByUsername("Duncan");
        List<Employee> list = employeeRepository.findAll();
        Employee e2 = new Employee();
        e2.setEmpId("3");
        e2.setUsername("Duncanxia@gmail.com");
        e2.setPassword("1234");
        Address a = new Address("123 Sesame Street",
                "",
                "New York",
                "12345",
                "USA"
        );
        e2.setAddress(a);
        Contact c = new Contact("123-456-7890",
                "Duncanxia@someplace.com",
                "Emergency1",
                "911-911-9999",
                "Emergency2",
                "911-911-9999");
        e2.setContact(c);
        employeeRepository.insert(e2);
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){

        Optional<Employee> e = employeeRepository.findEmployeeByUsername(username);
        if (username == null || !e.isPresent() || !e.get().getPassword().equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }

        String token = JwtUtil.generateToken(signingKey, username);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }
}
