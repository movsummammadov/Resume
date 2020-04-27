package com.mycompany.service.impl;


import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    private SkillDaoInter skillDao;

    @Override
    public List<Skill> getAllSkill() {
        return skillDao.getAllSkill();
    }

    @Override
    public List<Skill> getByName(String name) {
        return skillDao.getByName(name);
    }

    @Override
    public Skill getById(int id) {
        return skillDao.getById(id);
    }

    @Override
    public boolean addSkill(Skill s) {
        return skillDao.addSkill(s);
    }

    @Override
    public boolean removeSkill(int id) {
        return skillDao.removeSkill(id);
    }

    @Override
    public boolean updateSkill(Skill s) {
        return skillDao.updateSkill(s);
    }

}
