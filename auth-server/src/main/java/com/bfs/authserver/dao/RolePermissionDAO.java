package com.bfs.authserver.dao;

import com.bfs.authserver.domain.Permission;

public interface RolePermissionDAO {
    Permission getPermissionByRoleId(Integer roleId);
    Integer getPermissionId(Permission permission);
}
