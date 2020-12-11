package com.bfs.authserver.dao.imp;

import com.bfs.authserver.dao.RolePermissionDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bfs.authserver.dao.HibernateDAO;
import com.bfs.authserver.domain.RolePermission;
import com.bfs.authserver.domain.Permission;


@Repository("rolePermissionDAOimp")
public class RolePermissionDAOimp extends HibernateDAO<RolePermission> implements RolePermissionDAO {
    public RolePermissionDAOimp() {setClazz(RolePermission.class);}

    @Override
    public Permission getPermissionByRoleId(Integer roleId) {
        String hql = "FROM RolePermission RP WHERE RP.role.id =: input_roleId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("input_roleId", roleId);
        RolePermission result = (RolePermission) query.uniqueResult();
        return result.getPermission();
    }

    @Override
    public Integer getPermissionId(Permission permission) {
        return Integer.parseInt(permission.getId());
    }
}
