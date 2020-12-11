package ServiceTest;

import com.bfs.authserver.dao.HibernateDAO;
import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.dao.imp.UserDAOimp;
import com.bfs.authserver.dbconfig.HibernateConfig;
import com.bfs.authserver.dbconfig.HibernateProperty;
import com.bfs.authserver.domain.User;
import com.bfs.authserver.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyServiceTest {

    @Mock
    private Random random;
    @Mock
    private HibernateDAO hibernateDAO;

    @InjectMocks
    private UserService userService;
    @InjectMocks
    private HibernateConfig hibernateConfig;
    @InjectMocks
    private HibernateProperty hibernateProperty;
    @Mock
    private UserDAOimp userDAOimp;

    @Mock
    SessionFactory sessionFactory;
    @Mock
    Session session;


    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
        User u = new User();
        u.setUserName("duncan");
        u.setId(3);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(userDAOimp.getUserByEmail("duncanxia@gmail.com")).thenReturn(u);
    }

    @Test
    public void testGetUserByEmail() {
        User user = userDAOimp.getUserByEmail("duncanxia@gmail.com");
        Assertions.assertNotNull(user);
        Query query = Mockito.mock(Query.class);
        String hql = "FROM User U WHERE U.email = :input_email";
        Mockito.when(session.createQuery(hql)).thenReturn(query);
        if(user != null)
        Assertions.assertEquals(3,user.getId());
    }

    @Test
    public void testGetAllUser() {

    }
}
