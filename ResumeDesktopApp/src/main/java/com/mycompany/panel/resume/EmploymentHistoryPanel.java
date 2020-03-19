package com.mycompany.panel.resume;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.main.Context;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.mycompany.resume.config.Config;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public class EmploymentHistoryPanel extends javax.swing.JPanel {
    
    EmploymentHistoryDaoInter emHistoryDao=Context.instanceEmploymentHistoryDao();
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    
    private List<EmploymentHistory> list;
    
    public EmploymentHistoryPanel() {
        initComponents();
    }
    
    private void fillWindow(){
        fillTable();
    }
    
    private void fillTable(){
        list=emHistoryDao.getAllImploymentHistoryUserId(Config.loggedInUser.getId());
        System.out.println(list.size());
        Vector<Vector> rows=new Vector();
        for (EmploymentHistory em : list) {
            Vector<Object> row=new Vector();
            row.add(em.getHeader());
            row.add(em.getBeginDate());
            row.add(em.getEndDate());
            row.add(em.getJobDescription());
            rows.add(row);
            System.out.println("Movsum");
        }
        Vector<String> columns=new Vector<>();
        columns.add("Header");
        columns.add("Begin date");
        columns.add("End date");
        columns.add("Job Description");
        
        DefaultTableModel model=new DefaultTableModel(rows, columns);
        tblEmHistory.setModel(model);
    }
    
    public void fillUserEmploymentHistory(){
        fillWindow();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmHistory = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        tblEmHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEmHistory);

        btnAdd.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAdd)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmHistory;
    // End of variables declaration//GEN-END:variables
}
