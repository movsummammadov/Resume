package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int id=rs.getInt("id");
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));

    }

    @Override
    public List<EmploymentHistory> getAllImploymentHistoryUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt =c.prepareStatement("select * from employment_history where id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getEmploymentHistory(rs));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
          try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set header=?,begin_date=?,"
                    + "end_date=?,job_description=?,user_id=? where id=?");
            stmt.setString(1, eh.getHeader());
            stmt.setDate(2, eh.getBeginDate());
            stmt.setDate(3, eh.getEndDate());
            stmt.setString(4, eh.getJobDescription());
            stmt.setInt(5, eh.getUser().getId());
            stmt.setInt(6, eh.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from employment_history where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into employment_history(header,begin_date,"
                    + "end_date,job_description,user_id) values(?,?,?,?) ");
            stmt.setString(1, eh.getHeader());
            stmt.setDate(2, eh.getBeginDate());
            stmt.setDate(3, eh.getEndDate());
            stmt.setString(4, eh.getJobDescription());
            stmt.setInt(5, eh.getUser().getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
