package com.mycompany;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Mock
    UserRepositoryCustom userDao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeAll
    public static void setUp(){
        System.out.println("Set up called");
    }

    @BeforeEach
    public void before(){
        System.out.println("before called");

        MockitoAnnotations.initMocks(this);

        List<User> list=new ArrayList<>();
        User u=new User();
        u.setName("Movsum");
        u.setSurname("Mammadov");
        u.setEmail("movsum617@gmail.com");
        u.setNationality(new Country(1));
        list.add(u);
        Mockito.when(userDao.getAllUser(null,null,null)).thenReturn(list);
        Mockito.when(userDao.getAllUser("Movsum","Mammadov",1)).thenReturn(list);
        Mockito.when(userDao.findByEmailAndPassword(null,null)).thenReturn(null);
    }

    @Test
    public void testGivenNullThenGetAllUser(){
        List<User> list=userService.getAllUser(null,null,null);
        Assertions.assertEquals(1, list.size(),"user size must be 1");
        Mockito.verify(userDao,Mockito.atLeastOnce()).getAllUser(null,null,null);
    }

    @Test
    public void testGivenAllParamsThenGetAllUserByFilter(){
        List<User> list=userService.getAllUser("Movsum","Mammadov",1);
        Assertions.assertTrue(list.size()>0,"user size must be greater than zero");
        User user=list.get(0);
        Assertions.assertEquals("Movsum",user.getName(),"name wrong");
        Assertions.assertEquals("Mammadov",user.getSurname(),"surname wrong");
        Assertions.assertEquals(1,user.getNationality().getId(),"nationality id wrong");
        Mockito.verify(userDao,Mockito.atLeastOnce()).getAllUser("Movsum","Mammadov",1);
    }


    @Test
    public void testGivenNullFindByEmailAndPassword(){
        User user=userService.findByEmailAndPassword(null,null);
        Assertions.assertNull(user,"user must be null");
        Mockito.verify(userDao, Mockito.atLeastOnce()).findByEmailAndPassword(null,null);
    }
}
