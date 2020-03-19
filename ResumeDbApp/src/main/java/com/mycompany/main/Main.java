package com.mycompany.main;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;

/**
 *
 * @author Mammadov Movsum
 *       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 *       Date d=new Date(sdf.parse("1998-09-01").getTime());
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        EmploymentHistoryDaoInter userSkill=Context.instanceEmploymentHistoryDao();
        System.out.println(userSkill.getAllImploymentHistoryUserId(1));
    }
}
