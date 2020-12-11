package com.bfs.authserver.dao.imp;


import com.bfs.authserver.domain.Role;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.bfs.authserver.dao.UserRoleDAO;
import com.bfs.authserver.domain.UserRole;
import com.bfs.authserver.dao.HibernateDAO;

@Repository("userRoleDAOimp")
public class UserRoleDAOimp extends HibernateDAO<UserRole> implements UserRoleDAO{
    public UserRoleDAOimp() {setClazz(UserRole.class);}

    @Override
    public Role getRoleByUserId(Integer userId) {
        String hql = "FROM UserRole UR WHERE UR.user.id =: input_userId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("input_userId", userId);
        UserRole result = (UserRole) query.uniqueResult();
        return result.getRole();
    }

    @Override
    public Integer getRoleID(Role role) {
        return role.getId();
    }
}
