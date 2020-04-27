package com.mycompany.service.inter;

import com.mycompany.entity.Skill;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/
public interface SkillServiceInter {
    
    List<Skill> getAllSkill();

    public List<Skill> getByName(String name);
    
    Skill getById(int id);
    
    boolean addSkill(Skill s);
    
    boolean removeSkill(int id);
    
    boolean updateSkill(Skill s);
}
