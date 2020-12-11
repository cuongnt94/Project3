package com.bfs.authserver.controller;


import com.bfs.authserver.domain.RegistrationToken;
import com.bfs.authserver.domain.User;
import com.bfs.authserver.service.RegistrationTokenService;
import com.bfs.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Controller
public class RegisterController {

    UserService userService;
    RegistrationTokenService registrationTokenService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRegistrationTokenService(RegistrationTokenService registrationTokenService){
        this.registrationTokenService = registrationTokenService;
    }
    @RequestMapping("/register")
    public String register(){
    return "register"; }

    @PostMapping("/register")
    public String register(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest,  User user, Model model, @RequestParam("token") String token ) throws ParseException {


        System.out.println(user.getEmail()+"------"+ token);
        List<RegistrationToken> tokenList = registrationTokenService.getAllTokens();
        List<User> userList = userService.getAllUsers();
        for(User u : userList){
            if(user.getEmail().equalsIgnoreCase(u.getEmail())){
                model.addAttribute("error", "This email is already in use");
                return "register";
            }
        }
        for(RegistrationToken r : tokenList){

            if(r.getToken().equalsIgnoreCase(token)) {
                if (r.isUsed()){
                    model.addAttribute("error", "This token has already been used");
                    return "register";
                }
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDate = date.format(myFormatObj);

                // check token duration
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date1 = simpleDateFormat.parse(formattedDate);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date2 = simpleDateFormat2.parse(r.getValidDuration());
                long diff= date1.getTime() -date2.getTime();
                double h = (double)diff/1000/60/60;
                if(h >3){
                    model.addAttribute("error", "token expired!");
                    return "register";
                }

                user.setCreateDate(formattedDate);
                user.setModificationDate(formattedDate);

                userService.createNewUser(user);

                r.setUsed(true);
                registrationTokenService.updateToken(r);
                return "login";
                }
        }

        model.addAttribute("error", "Invalid token");
        return "register";
    }
}
