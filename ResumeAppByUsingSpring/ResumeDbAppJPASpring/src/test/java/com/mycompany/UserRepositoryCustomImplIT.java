package com.mycompany;

import com.mycompany.dao.impl.UserRepositoryCustomImpl;
import com.mycompany.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
public class UserRepositoryCustomImplIT {

    @Autowired
            @Qualifier("userDao1")
    UserRepositoryCustomImpl userDao;

    @Test
    public void testGetAllUser(){
        List<User> list=userDao.getAllUser(null,null,null);
        System.out.println("list="+list);
    }
}
