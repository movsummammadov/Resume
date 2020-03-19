package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.sql.Connection;
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
public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Skill(id, name);

    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getSkill(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getById(int id) {
        Skill result = new Skill();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where id="+id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getSkill(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addSkill(Skill s) {
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("insert into skill(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getName());
            ResultSet generatedKeys=stmt.getGeneratedKeys();
            if(generatedKeys.next()){
                s.setId(generatedKeys.getInt(1));
            }
            return stmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSkill(int id) {
       try(Connection c=connect()){
           Statement stmt=c.createStatement();
           return stmt.execute("delete from skill where id="+id);
       }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSkill(Skill s) {
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("update skill set name=? where id=?");
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getId());
            return stmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
