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

/**
 *
 * @author Movsum Mammadov
 *
 *
 *
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address=rs.getString("address");
        String password=rs.getString("password");
        String profileDescription = rs.getString("profile_description");
        Date birthdate = rs.getDate("birthdate");
        int birthplaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String birthplaceStr = rs.getString("birthplace");
        String nationalityStr = rs.getString("nationality");

        Country birthplace = new Country(birthplaceId, birthplaceStr, null);
        Country nationality = new Country(nationalityId, null, nationalityStr);

        User u= new User(id, name, surname, email, phone,address,profileDescription, birthdate, birthplace, nationality);
        u.setPassword(password);
        return u;
    }
    private User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String password=rs.getString("password");
        String address = rs.getString("address");
        String profileDescription = rs.getString("profile_description");
        Date birthdate = rs.getDate("birthdate");
        User user= new User(id,name,surname,email,phone,address,profileDescription,birthdate,null,null);
        user.setPassword(password);
        return user;
    }

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
                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public List<User> getAllUser(String name,String surname,Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String sql="SELECT"
                    + "	u.*,"
                    + "	c.name birthplace,"
                    + "	n.nationality "
                    + " FROM USER u"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id where 1+1 ";
            if(name!=null && !name.trim().isEmpty()){
                sql+=" and u.name=? ";
            }
            if(surname!=null && !surname.trim().isEmpty()){
                sql+=" and u.surname=? ";
            }
            if(nationalityId!=null){
                sql+=" and u.nationality_id=? ";
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            int i=1;
            if(name!=null && !name.trim().isEmpty()){
                stmt.setString(i,name);
                i++;
            }
            if(surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i,surname);
                i++;
            }
            if(nationalityId!=null){
                stmt.setInt(i,nationalityId);
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User u=null;
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("select * from user where email=? and password=?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                u=getUserSimple(rs);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return u;
    }
    @Override
    public User findByEmail(String email) {
        User u=null;
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("select * from user where email=?");
            stmt.setString(1,email);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                u=getUserSimple(rs);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	c.name birthplace,"
                    + "	n.nationality "
                    + " FROM USER u"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private BCrypt.Hasher crypt=BCrypt.withDefaults();

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, email=?, phone=?,"
                    + " address=?, profile_description=?, birthdate=?, birthplace_id=?, nationality_id=?,password=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getAddress());
            stmt.setString(6, u.getProfileDescription());
            stmt.setDate(7, u.getBirthdate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setString(10, crypt.hashToString(4,u.getPassword().toCharArray()));
            stmt.setInt(11, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int userId) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id=" + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User u) {
        try(Connection c=connect()){
            PreparedStatement stmt=c.prepareStatement("insert into user(name,surname,email,phone,"
                    + "address,profile_description,birthdate,birthplace_id,nationality_id,password)"
                    + " values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getAddress());
            stmt.setString(6, u.getProfileDescription());
            stmt.setDate(7, u.getBirthdate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setString(10,crypt.hashToString(4,u.getPassword().toCharArray()));
            return stmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
