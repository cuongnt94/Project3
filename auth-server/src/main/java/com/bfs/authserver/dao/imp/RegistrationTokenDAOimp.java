package com.bfs.authserver.dao.imp;

import com.bfs.authserver.dao.HibernateDAO;
import com.bfs.authserver.dao.RegistrationTokenDAO;
import com.bfs.authserver.domain.Permission;
import com.bfs.authserver.domain.RegistrationToken;
import com.bfs.authserver.domain.RolePermission;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("RegistrationTokenDAOimp")
public class RegistrationTokenDAOimp extends HibernateDAO<RegistrationToken> implements RegistrationTokenDAO {
    public RegistrationTokenDAOimp() {setClazz(RegistrationToken.class);}

    @Override
    public List<RegistrationToken> getAllTokens() {
        String hql = "FROM RegistrationToken";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void updateToken(RegistrationToken registrationToken) {
        getCurrentSession().saveOrUpdate(registrationToken);

    }
}
