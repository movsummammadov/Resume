package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
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
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getCountry(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Country getById(int id) {
        Country result = new Country();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where id=" + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addCountry(Country c) {
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("insert into country(name,nationality) values(?,?)");
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getNationality());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(int id) {
        try (Connection con = connect()) {
            Statement stmt = con.createStatement();
            return stmt.execute("delete from country where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCountry(Country c) {
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("update country set name=?,nationality=? where id=?");
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getNationality());
            stmt.setInt(3, c.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

}
