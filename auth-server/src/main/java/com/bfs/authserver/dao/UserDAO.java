package com.bfs.authserver.dao;
import com.bfs.authserver.domain.User;
import java.util.*;

public interface UserDAO {
    List<User> getAllUser();
    User getUserById(Integer id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);

    Integer createNewUser(User user);
}
