package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
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
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("user_skill_id");
        int userId = rs.getInt("id");
        int power = rs.getInt("power");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
//        return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
return null;
    }

    @Override
    public List<UserSkill> getUserSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT"
                    + "	s.id skill_id,"
                    + "	u.*,"
                    + "	s.name skill_name,"
                    + "	us.power,"
                    + " us.id user_skill_id"
                    + " FROM"
                    + "	user_skill us"
                    + "	LEFT JOIN USER u ON u.id = us.user_id"
                    + "	LEFT JOIN skill s ON s.id = us.skill_id"
                    + " WHERE" 
                    + " us.user_id =? ");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getUserSkill(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUserSkill(UserSkill usk) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user_skill set user_id=?,skill_id=?,"
                    + "power=? where id=?");
//            stmt.setInt(1, usk.getUser().getId());
//            stmt.setInt(2, usk.getSkill().getId());
            stmt.setInt(3, usk.getPower());
            stmt.setInt(4, usk.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user_skill where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserSkill(UserSkill usk) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user_skill(user_id,skill_id,"
                    + "power) values(?,?,?)");
//            stmt.setInt(1, usk.getUser().getId());
//            stmt.setInt(2, usk.getSkill().getId());
            stmt.setInt(3, usk.getPower());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
