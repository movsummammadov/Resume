package com.mycompany.service.impl;


import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();

    }

    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
       return userDao.getAllUser(name,surname,nationalityId);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email,password);
    }


    @Override
    public User findByEmail(String email) {
        return  userDao.findByEmail(email);
    }
    
    @Override
    public User getById(int userId) {
        return  userDao.getById(userId);
    }

    @Override
    public boolean removeUser(int userId) {
        return userDao.removeUser(userId);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

}
