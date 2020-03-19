package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface UserDaoInter {
    
    List<User> getAllUser();
    
    User getById(int UserId);
    
    boolean updateUser(User u);
    
    boolean removeUser(int id);
    
    boolean addUser(User u);
}
