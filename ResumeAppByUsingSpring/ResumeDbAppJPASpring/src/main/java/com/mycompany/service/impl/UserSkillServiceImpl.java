package com.mycompany.service.impl;

import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;
import com.mycompany.service.inter.UserSkillServiceInter;
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
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    private UserSkillDaoInter userSkillDao;

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        return userSkillDao.getAllUserSkillByUserId(userId);
    }

    @Override
    public boolean updateUserSkill(UserSkill usk) {
        return userSkillDao.updateUserSkill(usk);
    }

    @Override
    public boolean removeUserSkill(int id) {
        return userSkillDao.removeUserSkill(id);
    }

    @Override
    public boolean addUserSkill(UserSkill usk) {
        return userSkillDao.addUserSkill(usk);
    }

}
