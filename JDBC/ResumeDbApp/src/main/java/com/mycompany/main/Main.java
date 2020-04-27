package com.mycompany.main;

import com.mycompany.dao.impl.SkillDaoImpl;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;

import java.util.List;
import java.util.jar.JarOutputStream;

/**
 *
 * @author Mammadov Movsum
 *       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 *       Date d=new Date(sdf.parse("1998-09-01").getTime());
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter userDao=Context.instanceSkillDao();
        System.out.println(userDao.getByName("PL\\SQL"));

    }
}
