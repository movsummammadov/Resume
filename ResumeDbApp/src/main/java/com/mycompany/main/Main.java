package com.mycompany.main;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
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
        EmploymentHistoryDaoInter userSkill=Context.instanceEmploymentHistoryDao();
        List<EmploymentHistory> list=userSkill.getAllImploymentHistoryUserId(1);
        System.out.println(list);
    }
}
