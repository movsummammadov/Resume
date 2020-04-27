package com.mycompany.service.inter;

import com.mycompany.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public interface EmploymentHistoryServiceInter {
    
    List<EmploymentHistory> getAllImploymentHistoryByUserId(int userId);

    EmploymentHistory getById(int id);

    public List<EmploymentHistory> getAll();
    
    boolean updateEmploymentHistory(EmploymentHistory eh);
    
     boolean removeEmploymentHistory(int id);
    
    boolean addEmploymentHistory(EmploymentHistory eh);
}
