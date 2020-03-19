package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Movsum Mammadov
 *
 */
public abstract class AbstractDao {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resumedb";
        String username = "Movsum";
        String password = "Movsum13.";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
