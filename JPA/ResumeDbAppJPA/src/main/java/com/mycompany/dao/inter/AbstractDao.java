package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Movsum Mammadov
 *
 */
public abstract class AbstractDao {

//    public Connection connect() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/resumedb";
//        String username = "Movsum";
//        String password = "Movsum13.";
//        Connection c = DriverManager.getConnection(url, username, password);
//        return c;
//    }
    
    private static EntityManagerFactory emf=null;
    
    public EntityManager em(){
        if(emf==null){
            emf=Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager em=emf.createEntityManager();
        return em;
    }
    
    public void close(){
        emf.close();
    }
}
