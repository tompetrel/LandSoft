/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Customers;

/**
 *
 * @author TAI
 */
public final class panelCustomers extends javax.swing.JPanel {

    /**
     * Creates new form panelCustomers
     */
    void initGUIPanelCustomers() {
        try {
            if (!controller.AccountsController.getRoleNameWithUserName(frmLogin.userName).equals("Administrator")) {
                btnDelete.setVisible(false);
            }

            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            radioMale.setSelected(true);

            TableColumnModel columnModel = tblCustomer.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(5);
            columnModel.getColumn(1).setPreferredWidth(5);
            columnModel.getColumn(2).setPreferredWidth(50);
            columnModel.getColumn(3).setPreferredWidth(20);
            columnModel.getColumn(4).setPreferredWidth(10);
            columnModel.getColumn(5).setPreferredWidth(30);
            columnModel.getColumn(6).setPreferredWidth(100);
            columnModel.getColumn(7).setPreferredWidth(30);
            columnModel.getColumn(8).setPreferredWidth(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void findCustomers() {
        TableRowSorter rowSorter = new TableRowSorter(tblCustomer.getModel());
        tblCustomer.setRowSorter(rowSorter);
        txtFind.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = txtFind.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = txtFind.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    //Khởi tạo dữ liệu bảng Customers
    void initTableCustomers() {
        try {
            Vector vCol = new Vector();
            vCol.add("No.");
            vCol.add("CustomerID");
            vCol.add("First name");
            vCol.add("Last name");
            vCol.add("Gender");
            vCol.add("Birth day");
            vCol.add("Email");
            vCol.add("Phone number");
            vCol.add("Address");
            Vector vData = new Vector();
            List<Customers> listCustomers = controller.CustomersController.getListCustomers();
            int countRow = 0;
            for (Customers customers : listCustomers) {
                Vector vTemp = new Vector();
                countRow++;
                vTemp.add(countRow);
                vTemp.add(customers.getCustomerID());
                vTemp.add(customers.getFirstName());
                vTemp.add(customers.getLastName());
                if (customers.isGender()) {
                    vTemp.add("Male");
                } else {
                    vTemp.add("Female");
                }
                vTemp.add(customers.getBirthDay());
                vTemp.add(customers.getEmail());
                vTemp.add(customers.getPhoneNumber());
                vTemp.add(customers.getAddress());
                vData.add(vTemp);
            }
            DefaultTableModel model = new DefaultTableModel(vData, vCol);
            tblCustomer.setModel(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public panelCustomers() {
        initComponents();
        initTableCustomers();
        initGUIPanelCustomers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chooseDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tblCustomer.setRowHeight(25);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        add(panelTable, java.awt.BorderLayout.PAGE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(1236, 269));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("BỉrthDay:");

        chooseDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("FirstName:");

        txtFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("LastName:");

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Phone number:");

        txtPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        jLabel7.setText("Find:");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFindMouseClicked(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        btnRefresh.setText("Refesh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Gender:");

        buttonGroup2.add(radioMale);
        radioMale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioMale.setText("Male");

        buttonGroup2.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioFemale.setText("Female");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane3.setViewportView(txtAddress);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Address:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID:");

        txtCustomerID.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(radioMale)
                                .addGap(18, 18, 18)
                                .addComponent(radioFemale))
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtFirstName))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(chooseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtPhoneNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(txtCustomerID))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel9});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel6, jLabel8});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(jLabel1)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(radioMale)
                            .addComponent(radioFemale)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        TableModel model = tblCustomer.getModel();
        int index = tblCustomer.getSelectedRow();
        String CustomerID = tblCustomer.getValueAt(index, 1).toString();
        String firstName = tblCustomer.getValueAt(index, 2).toString();
        String lastName = tblCustomer.getValueAt(index, 3).toString();
        String gender = tblCustomer.getValueAt(index, 4).toString();
        try {
            Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(index, 5));
            chooseDate.setDate(birthDay);
        } catch (ParseException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
        String email = tblCustomer.getValueAt(index, 6).toString();
        String phoneNumber = tblCustomer.getValueAt(index, 7).toString();
        String address = tblCustomer.getValueAt(index, 8).toString();

        txtCustomerID.setText(CustomerID);
        txtFirstName.setText(firstName);
        txtLastName.setText(lastName);
        if (gender.equals("Male")) {
            radioMale.setSelected(true);
        } else {
            radioFemale.setSelected(true);
        }
        txtEmail.setText(email);
        txtPhoneNumber.setText(phoneNumber);
        txtAddress.setText(address);
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void txtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseClicked
        findCustomers();
    }//GEN-LAST:event_txtFindMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initTableCustomers();
        initGUIPanelCustomers();

        txtCustomerID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        radioMale.setSelected(true);
        chooseDate.setDate(null);
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            boolean gender = false;
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String address = txtAddress.getText();

            //first name
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First name not be empty !");
                txtFirstName.requestFocus();
                return;
            }
            if (firstName.length() > 20) {
                JOptionPane.showMessageDialog(null, "First name no more than 20 characters !");
                txtFirstName.requestFocus();
                return;
            }
            //last name
            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last name not be empty !");
                txtLastName.requestFocus();
                return;
            }
            if (lastName.length() > 20) {
                JOptionPane.showMessageDialog(null, "Last name no more than 20 characters !");
                txtLastName.requestFocus();
                return;
            }
            //Gender
            if (radioMale.isSelected()) {
                gender = true;
            } else {
                gender = false;
            }
            String birthDay;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                birthDay = dateFormat.format(chooseDate.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose birthDay");
                chooseDate.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email not be empty !");
                txtEmail.requestFocus();
                return;
            }
            if (email.length() > 30) {
                JOptionPane.showMessageDialog(null, "Email no more than 30 characters !");
                txtEmail.requestFocus();
                return;
            }
            if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Email:  " + email + "  illegal. Exemple: ABC@gmail.com");
                txtEmail.requestFocus();
                return;
            }
            if (controller.CustomersController.checkExistEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email " + email + " exist !");
                txtEmail.requestFocus();
                return;
            }
            //Phone number
            if (phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone number not be empty !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (phoneNumber.length() > 10) {
                JOptionPane.showMessageDialog(null, "Phone number no more than 10 number !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (!phoneNumber.matches("0\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
                JOptionPane.showMessageDialog(null, "Phone number:  " + phoneNumber + "  illegal. Exemple: 0123456789");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (controller.CustomersController.checkExistPhoneNumber(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "Phone number " + phoneNumber + " exist !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address not be empty !");
                txtAddress.requestFocus();
                return;
            }
            if (address.length() > 50) {
                JOptionPane.showMessageDialog(null, "Address no more than 50 character!");
                txtAddress.requestFocus();
                return;
            }

            int index = JOptionPane.showConfirmDialog(null, "Are you want to Add new Customer: " + firstName + " " + lastName + " ?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                controller.CustomersController.addNewCustomers(firstName, lastName, gender, birthDay, email, phoneNumber, address);
                btnRefreshActionPerformed(evt);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int CustomerID = Integer.parseInt(txtCustomerID.getText());
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            boolean gender = false;
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String address = txtAddress.getText();

            //first name
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First name not be empty !");
                txtFirstName.requestFocus();
                return;
            }
            if (firstName.length() > 20) {
                JOptionPane.showMessageDialog(null, "First name no more than 20 characters !");
                txtFirstName.requestFocus();
                return;
            }
            //last name
            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last name not be empty !");
                txtLastName.requestFocus();
                return;
            }
            if (lastName.length() > 20) {
                JOptionPane.showMessageDialog(null, "Last name no more than 20 characters !");
                txtLastName.requestFocus();
                return;
            }
            //Gender
            if (radioMale.isSelected()) {
                gender = true;
            } else {
                gender = false;
            }
            String birthDay;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                birthDay = dateFormat.format(chooseDate.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose birthDay");
                chooseDate.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email not be empty !");
                txtEmail.requestFocus();
                return;
            }
            if (email.length() > 30) {
                JOptionPane.showMessageDialog(null, "Email no more than 30 characters !");
                txtEmail.requestFocus();
                return;
            }
            if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Email:  " + email + "  illegal. Exemple: ABC@gmail.com");
                txtEmail.requestFocus();
                return;
            }
            if (controller.CustomersController.checkExistEmailOfCustomerOther(email, CustomerID)) {
                JOptionPane.showMessageDialog(null, "Email " + email + " exist !");
                txtEmail.requestFocus();
                return;
            }
            //Phone number
            if (phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone number not be empty !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (phoneNumber.length() > 10) {
                JOptionPane.showMessageDialog(null, "Phone number no more than 10 number !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (!phoneNumber.matches("0\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
                JOptionPane.showMessageDialog(null, "Phone number:  " + phoneNumber + "  illegal. Exemple: 0123456789");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (controller.CustomersController.checkExistPhoneNumberOfCustomerOther(phoneNumber, CustomerID)) {
                JOptionPane.showMessageDialog(null, "Phone number " + phoneNumber + " exist !");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address not be empty !");
                txtAddress.requestFocus();
                return;
            }
            if (address.length() > 50) {
                JOptionPane.showMessageDialog(null, "Address no more than 50 character!");
                txtAddress.requestFocus();
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Update Customer: " + firstName + " " + lastName + " ?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                Customers customers = new Customers(CustomerID, firstName, lastName, gender, birthDay, email, phoneNumber, address);
                controller.CustomersController.updateCustomer(customers);
                btnRefreshActionPerformed(evt);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int CustomerID = Integer.parseInt(txtCustomerID.getText());
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Delete Customer: " + firstName + " " + lastName + " ?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                controller.CustomersController.deleteCustomer(CustomerID);
                btnRefreshActionPerformed(evt);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser chooseDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelTable;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
