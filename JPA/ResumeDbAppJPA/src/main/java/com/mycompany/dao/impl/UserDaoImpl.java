package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Movsum Mammadov
 *
 *
 *
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAllUser() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	c.name birthplace,"
                    + "	n.nationality "
                    + " FROM USER u"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
//                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String sql = "SELECT"
                    + "	u.*,"
                    + "	c.name birthplace,"
                    + "	n.nationality "
                    + " FROM USER u"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id where 1+1 ";
            if (name != null && !name.trim().isEmpty()) {
                sql += " and u.name=? ";
            }
            if (surname != null && !surname.trim().isEmpty()) {
                sql += " and u.surname=? ";
            }
            if (nationalityId != null) {
                sql += " and u.nationality_id=? ";
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
                i++;
            }
            if (nationalityId != null) {
                stmt.setInt(i, nationalityId);
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
//                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User u = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                u=getUserSimple(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public User findByEmail(String email) {
        User u = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                u=getUserSimple(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public User getById(int userId) {
        EntityManager em=em();
        User user=em.find(User.class, userId);
        em.close();
        return user;
    }
     @Override
    public boolean removeUser(int userId) {
        EntityManager em=em();
        User user=em.find(User.class, userId);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean updateUser(User u) {
        //u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

 
    
    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
