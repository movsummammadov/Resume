package com.mycompany.panel.resume;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.main.Context;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.mycompany.resume.config.Config;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class EmploymentHistoryPanel extends javax.swing.JPanel {

    EmploymentHistoryDaoInter emHistoryDao = Context.instanceEmploymentHistoryDao();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private List<EmploymentHistory> list;

    public EmploymentHistoryPanel() {
        initComponents();
    }

    private void fillWindow() {
        fillTable();
    }

    private void fillTable() {
        list = emHistoryDao.getAllImploymentHistoryUserId(Config.loggedInUser.getId());
        Vector<Vector> rows = new Vector();
        for (EmploymentHistory em : list) {
            Vector<Object> row = new Vector();
            row.add(em.getId());
            row.add(em.getHeader());
            row.add(em.getBeginDate());
            row.add(em.getEndDate());
            row.add(em.getJobDescription());
            rows.add(row);
        }
        Vector<String> columns = new Vector<>();
        columns.add("№");
        columns.add("Header");
        columns.add("Begin date");
        columns.add("End date");
        columns.add("Job Description");

        DefaultTableModel model = new DefaultTableModel(rows, columns);
        tblEmHistory.setModel(model);
    }

    public void fillUserEmploymentHistory() {
        fillWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmHistory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblBeginDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        txtBeginDate = new javax.swing.JTextField();
        lblJobDescription = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaJobDescription = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        txtHeader = new javax.swing.JTextField();

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

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblHeader.setText("header");

        lblBeginDate.setText("Begin date");

        lblEndDate.setText("End date");

        lblJobDescription.setText("Job Description");

        txtAreaJobDescription.setColumns(20);
        txtAreaJobDescription.setRows(5);
        jScrollPane3.setViewportView(txtAreaJobDescription);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBeginDate)
                                    .addComponent(lblEndDate)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblHeader)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtBeginDate)
                            .addComponent(txtHeader)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblJobDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeader)
                            .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUpdate)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeginDate)
                    .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndDate))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblJobDescription))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String header = txtHeader.getText();
        String bd = txtBeginDate.getText();
        String ed = txtEndDate.getText();
        String jobDescription = txtAreaJobDescription.getText();
        EmploymentHistory em = null;
        if (header != null && bd != null && jobDescription != null && !header.trim().isEmpty()
                && !bd.trim().isEmpty() && !jobDescription.trim().isEmpty()) {
            try {
                Date beginDate = new Date(sdf.parse(bd).getTime());
                em = new EmploymentHistory(0, header, beginDate, null, jobDescription, Config.loggedInUser);
                emHistoryDao.addEmploymentHistory(em);
            } catch (ParseException ex) {
                System.out.println("Don't converted");
            }
        } else if (header != null && bd != null && ed != null && jobDescription != null && !header.trim().isEmpty()
                && !bd.trim().isEmpty() && !ed.trim().isEmpty() && !jobDescription.trim().isEmpty()) {
            try {
                Date beginDate = new Date(sdf.parse(bd).getTime());
                Date endDate=new Date(sdf.parse(ed).getTime());
                em = new EmploymentHistory(0, header, beginDate, endDate, jobDescription, Config.loggedInUser);
                emHistoryDao.addEmploymentHistory(em);
            } catch (ParseException ex) {
                System.out.println("Don't converted");
            }
        }
        fillWindow();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            EmploymentHistory em=list.get(tblEmHistory.getSelectedRow());
            String ed = txtEndDate.getText();
            if(ed!=null && !ed.trim().isEmpty() ){
            Date endDate=new Date(sdf.parse(ed).getTime());
            em.setEndDate(endDate);
            emHistoryDao.updateEmploymentHistory(em);
            }
        } catch (ParseException ex) {
            System.out.println("Don't converted");
        }
        fillWindow();
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBeginDate;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblJobDescription;
    private javax.swing.JTable tblEmHistory;
    private javax.swing.JTextArea txtAreaJobDescription;
    private javax.swing.JTextField txtBeginDate;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtHeader;
    // End of variables declaration//GEN-END:variables
}
