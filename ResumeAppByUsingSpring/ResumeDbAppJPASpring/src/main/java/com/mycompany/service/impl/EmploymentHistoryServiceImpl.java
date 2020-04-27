package com.mycompany.service.impl;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 */
@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Autowired
    private EmploymentHistoryDaoInter employmentHistoryDao;

    @Override
    public List<EmploymentHistory> getAll() {
        return employmentHistoryDao.getAll();
    }

    @Override
    public List<EmploymentHistory> getAllImploymentHistoryByUserId(int userId) {
        return employmentHistoryDao.getAllImploymentHistoryByUserId(userId);
    }

    public EmploymentHistory getById(int id) {
        return employmentHistoryDao.getById(id);
    }
    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        return employmentHistoryDao.updateEmploymentHistory(eh);
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        return employmentHistoryDao.removeEmploymentHistory(id);
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        return employmentHistoryDao.addEmploymentHistory(eh);
    }

}
