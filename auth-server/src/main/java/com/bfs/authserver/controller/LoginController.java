package com.bfs.authserver.controller;

import com.bfs.authserver.dbconfig.HibernateConfig;
import com.bfs.authserver.domain.User;
import com.bfs.authserver.security.CookieUtil;
import com.bfs.authserver.security.JwtUtil;
import com.bfs.authserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends HttpServlet {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private static final Map<String, String> credentials = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(LoginController.class);


    public LoginController() {
        //credentials.put("admin@admin.com", "admin");
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // get user email and password
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        logger.info("Logger----Email =" + email + " password =" +password);

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.getUserByEmail(email);
        PrintWriter out = response.getWriter();
        request.setAttribute("loginResult", true);

//        out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");

//        Integer personId = user.getPersonId();
//        Integer userId = user.getId();
//        Integer roleId = ... (if roleID==1,redirect to http://localhost:4200/home; if roleId==2, redirect to HR page )


        if (user == null || !password.equals(user.getPassword())) {

            out.println("Invalid username or password! Please return, and try again");


        } else {
            logger.info("Correct username + password entered logging in");
            String token = JwtUtil.generateToken(signingKey, userService.generateTokenInfo(user));
            CookieUtil.create(response, jwtTokenCookieName, token, false, -1, "localhost");
            response.sendRedirect("http://localhost:4200/home");
        }
    }
    @PostMapping("/login")
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);
    }

}
