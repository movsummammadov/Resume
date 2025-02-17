package com.mycompany.service.inter;

import com.mycompany.entity.User;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface UserServiceInter {
    
    List<User> getAllUser();

    List<User> getAllUser(String name, String surname, Integer nationalityId);

    User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email);
    
    User getById(int userId);
    
    boolean updateUser(User u);
    
    boolean removeUser(int id);
    
    boolean addUser(User u);
}
