package com.bfs.authserver.dao.imp;


import com.bfs.authserver.dao.HibernateDAO;
import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.domain.Person;
import com.bfs.authserver.domain.Role;
import com.bfs.authserver.domain.User;
import com.bfs.authserver.domain.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import java.time.LocalDate;

@Repository("employeeHibernateDAOimp")
public class UserDAOimp extends HibernateDAO<User> implements UserDAO {

    public UserDAOimp() {setClazz(User.class);};

    @Override
    public User getUserById(Integer id) {
        String hql = "FROM User  U WHERE U.id =: id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        User result = (User) query.uniqueResult();
        return result;
 }
    @Override
    public List<User> getAllUser() {
        String hql = "FROM User U";

        List<User> result = getCurrentSession().createQuery(hql).getResultList();
        return result;
    }
    @Override
    public User getUserByUsername(String username) {
        String hql = "FROM User U WHERE U.userName =: input_username";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("input_username", username);
        User result = (User) query.uniqueResult();
        return result;
    }

    @Override
    public User getUserByEmail(String email) {
        String hql = "FROM User U WHERE U.email = :input_email";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("input_email", email);
        User result = (User) query.uniqueResult();
        return result;
    }

    @Override
    public Integer createNewUser(User user) {

        Person person= new Person();
        person.setEmail(user.getEmail());
        Integer id = (Integer) getCurrentSession().save("person", person);
           user.setPersonId(id);
        Integer userId = (Integer) getCurrentSession().save("user", user);

         String hql = "FROM Role R where R.id = 1";
         Role role = (Role) getCurrentSession().createQuery(hql).uniqueResult();
         UserRole userRole = new UserRole();
         userRole.setRole(role);
         userRole.setUser(user);
         userRole.setCreateDate(LocalDate.now().toString());
         getCurrentSession().save(userRole);


//        user.setPersonId("4");


        return userId;
    }
}
