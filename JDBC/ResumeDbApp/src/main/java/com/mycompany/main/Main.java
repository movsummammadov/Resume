package com.mycompany.main;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;

import java.util.List;

/**
 *
 * @author Mammadov Movsum
 *       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 *       Date d=new Date(sdf.parse("1998-09-01").getTime());
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao=Context.instanceUserDao();
       User u=userDao.getById(3);
       u.setPassword("12345");
        userDao.updateUser(u);

    }
}
