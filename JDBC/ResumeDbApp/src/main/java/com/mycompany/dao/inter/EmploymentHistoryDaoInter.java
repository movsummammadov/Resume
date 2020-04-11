package com.mycompany.dao.inter;

import com.mycompany.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface EmploymentHistoryDaoInter {
    
    List<EmploymentHistory> getAllImploymentHistoryUserId(int userId);
    
    boolean updateEmploymentHistory(EmploymentHistory eh);
    
     boolean removeEmploymentHistory(int id);
    
    boolean addEmploymentHistory(EmploymentHistory eh);
}
