package com.bfs.authserver.dao;

import com.bfs.authserver.domain.Role;

public interface UserRoleDAO {
    Role getRoleByUserId(Integer userId);
    Integer getRoleID(Role role);
}
