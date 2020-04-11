package com.mycompany.panel.resume;

import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.mycompany.resume.config.Config;

/**
 *
 * @author Movsum Mammadov
 *
 *
 */
public class DetailsPanel extends javax.swing.JPanel {

    private CountryDaoInter countryDao = Context.instanceCountryDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DetailsPanel() {
        initComponents();
    }

    private void fillWindow() {
        List<Country> countries = countryDao.getAllCountry();
        for (Country country : countries) {
            cbCountry.addItem(country);
        }
        List<Country> nationalitys = countryDao.getAllCountry();
        for (Country nationality : nationalitys) {
            cbNationality.addItem(nationality);
        }
    }

    public void fillUserDetails() {
        fillWindow();
        User loggedInUser=Config.loggedInUser;
        txtAddress.setText(loggedInUser.getAddress());
        txtPhone.setText(loggedInUser.getPhone());
        txtEmail.setText(loggedInUser.getEmail());
        Date bd = loggedInUser.getBirthdate();
        String birthdate = sdf.format(bd);
        txtBirthdate.setText(birthdate);
        cbCountry.setSelectedItem(loggedInUser.getBirthplace());
        cbNationality.setSelectedItem(loggedInUser.getNationality());

    }

    public void fillUser(User user) {
        try {
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            String bd = txtBirthdate.getText();
            Date birthdate = new Date(sdf.parse(bd).getTime());
            Country birthplace = (Country) cbCountry.getSelectedItem();
            Country nationality = (Country) cbNationality.getSelectedItem();
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);
            user.setBirthdate(birthdate);
            user.setBirthplace(birthplace);
            user.setNationality(nationality);
        } catch (ParseException ex) {
            System.out.println("Don't converted");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        lblBirthdate = new javax.swing.JLabel();
        lblBirthplace = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        cbCountry = new javax.swing.JComboBox<>();
        cbNationality = new javax.swing.JComboBox<>();

        lblAddress.setText("Address");

        lblPhone.setText("Phone");

        lblEmail.setText("Email");

        lblBirthdate.setText("Birthdate");

        lblBirthplace.setText("Birthplace");

        lblNationality.setText("Nationality");

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(lblBirthplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbCountry, javax.swing.GroupLayout.Alignment.LEADING, 0, 123, Short.MAX_VALUE)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(456, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthplace)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNationality)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbCountry;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthplace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
