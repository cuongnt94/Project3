package com.bfs.authserver.controller;


import com.bfs.authserver.repository.EmployeeRepository;
import com.bfs.authserver.security.CookieUtil;
import com.bfs.authserver.security.JwtUtil;
import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@RestController// Controller
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
//      //  Optional<Employee> e = employeeRepository.findEmployeeByUsername("Duncan");
//        List<Employee> list = employeeRepository.findAll();
//        Employee e2 = new Employee();
//        e2.setEmpId("3");
//        e2.setUsername("Duncanxia@gmail.com");
//        e2.setPassword("1234");
//        Address a = new Address("123 Sesame Street",
//                "",
//                "New York",
//                "12345",
//                "USA"
//        );
//        e2.setAddress(a);
//        Contact c = new Contact("123-456-7890",
//                "Duncanxia@someplace.com",
//                "Emergency1",
//                "911-911-9999",
//                "Emergency2",
//                "911-911-9999");
//        e2.setContact(c);
//        //employeeRepository.insert(e2);

        return "login";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> payLoad, HttpServletResponse httpServletResponse,String redirect, Model model){
        String username = (String) payLoad.get("email");
        String password = (String) payLoad.get("password");
        Optional<Employee> e = employeeRepository.findEmployeeByUsername(username);
        List<Employee> employees= employeeRepository.findAll();
        if (username == null || !e.isPresent() || !e.get().getPassword().equals(password)){
            return "401";
        }

        String token = JwtUtil.generateToken(signingKey, e.get().getEmpId());
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
        //httpServletResponse.sendRedirect()
        return token;
    }
}
