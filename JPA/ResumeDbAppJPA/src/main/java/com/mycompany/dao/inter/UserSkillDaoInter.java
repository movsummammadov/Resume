package com.mycompany.dao.inter;

import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface UserSkillDaoInter {
    
    List<UserSkill> getAllUserSkillByUserId(int userId);
    
    boolean updateUserSkill(UserSkill usk);
    
    boolean removeUserSkill(int id);
    
    boolean addUserSkill(UserSkill usk);
}
