package com.mycompany.main;

import com.mycompany.dao.inter.*;
import com.mycompany.entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
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
        SkillDaoInter countryDao=Context.instanceSkillDao();


//        System.out.println(countryDao.addSkill(new Skill(null,"R")));
        System.out.println(countryDao.getAllSkill());
//        System.out.println(countryDao.removeSkill(79));
    }
}
