package com.mycompany.dao.inter;

import com.mycompany.entity.Skill;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/
public interface SkillDaoInter {
    
    List<Skill> getAllSkill();

    List<Skill> getByName(String name);
    
    Skill getById(int id);
    
    boolean addSkill(Skill s);
    
    boolean removeSkill(int id);
    
    boolean updateSkill(Skill s);
}
