package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;


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
       User u=userDao.getById(1);
        System.out.println(u.getEmail());

    }
}
