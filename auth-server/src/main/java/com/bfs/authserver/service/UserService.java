package com.bfs.authserver.service;


import com.bfs.authserver.dao.UserDAO;

import com.bfs.authserver.dao.RolePermissionDAO;
import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.dao.UserRoleDAO;
import com.bfs.authserver.dao.imp.UserDAOimp;

import com.bfs.authserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserService{

    private UserDAO userDAOimp;
    private UserRoleDAO userRoleDAOimp;
    private RolePermissionDAO rolePermissionDAOimp;


    @Autowired
    public void setContactDAO(UserDAO userDAOimp) {
        this.userDAOimp = userDAOimp;
    }
    @Autowired
    public void setUserRoleDAO(UserRoleDAO userRoleDAOimp) {this.userRoleDAOimp=userRoleDAOimp;}
    @Autowired
    public void setRolePermissionDAO(RolePermissionDAO rolePermissionDAOimp) {this.rolePermissionDAOimp=rolePermissionDAOimp;}

    @Transactional
    public List<User> getAllUsers() {
        return userDAOimp.getAllUser();
    }
    @Transactional
    public User getUserByEmail(String email){return userDAOimp.getUserByEmail(email);}
    @Transactional
    public int[] generateTokenInfo(User user) {
        /* Input: Username or Email
           Output: (String) "UserName, Email, RoleId, PermissionId"
    Step1: If the input contains '@', recognize it as Email; otherwise, recognize as Username.
    Step2: Use input to get UserId via UserDAO
    Step3: Use UserId in Step2 to get RoleId via UserRoleDAO
    Step4: Use RoleId in Step3 to get PermissionId via RolePermissionDAO
     */
        //User user = input.contains("@")? userDAOimp.getUserByEmail(input):userDAOimp.getUserByUsername(input);
       // if (user==null) return null;
        //user = userDAOimp.getUserByEmail(input);
        Integer userId = user.getId();
        Integer roleId = userRoleDAOimp.getRoleID(userRoleDAOimp.getRoleByUserId(userId));
        Integer permissionId = rolePermissionDAOimp.getPermissionId(rolePermissionDAOimp.getPermissionByRoleId(roleId));

        //String result = input.contains("@")? ","+input+",":input+",,";
        int[] result = new int[3];
        result[1] = roleId;
        result[2] = permissionId;
        result[0] = userId;
        return result;
    }


    @Transactional
    public Integer createNewUser(User user) {

        Integer id = userDAOimp.createNewUser(user);

        return id;
    }
}
