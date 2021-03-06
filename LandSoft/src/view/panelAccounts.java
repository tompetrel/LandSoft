/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Accounts;

/**
 *
 * @author TAI
 */
public final class panelAccounts extends javax.swing.JPanel {

    /**
     * Creates new form panelAccounts
     */
    byte[] image = null;
    File selectedPicture = null;

    void initTableAccounts() {
        try {
            Vector vCol = new Vector();
            vCol.add("No.");
            vCol.add("AccountID");
            vCol.add("Username");
            vCol.add("First name");
            vCol.add("Last name");
            vCol.add("Gender");
            vCol.add("Birth day");
            vCol.add("Email");
            vCol.add("Phone number");
            vCol.add("Address");
            vCol.add("Password");
            vCol.add("Image");
            vCol.add("RoleID");

            Vector vData = new Vector();
            int countRow = 0;
            List<Accounts> listAccounts = controller.AccountsController.getListAccounts();
            for (Accounts accounts : listAccounts) {
                Vector vTemp = new Vector();
                countRow++;
                vTemp.add(countRow);
                vTemp.add(accounts.getAccountID());
                vTemp.add(accounts.getUserName());
                vTemp.add(accounts.getFirstName());
                vTemp.add(accounts.getLastName());
                if (accounts.isGender()) {
                    vTemp.add("Male");
                } else {
                    vTemp.add("Female");
                }
                vTemp.add(accounts.getBirthDay());
                vTemp.add(accounts.getEmail());
                vTemp.add(accounts.getPhoneNumber());
                vTemp.add(accounts.getAddress());
                vTemp.add(accounts.getPassword());
                vTemp.add(accounts.getImage());
                vTemp.add(accounts.getRoleID());
                vData.add(vTemp);

            }
            DefaultTableModel model = new DefaultTableModel(vData, vCol);
            tblAccounts.setModel(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void initGUIPanel() {
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        radioMale.setSelected(true);
    }

    void findAccounts() {
        TableRowSorter rowSorter = new TableRowSorter(tblAccounts.getModel());
        tblAccounts.setRowSorter(rowSorter);
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

    void initGUIDialogRole() {
        try {
            cbbRole.removeAllItems();
            List<String> listRoleName = controller.AccountsController.getListRoleName();
            for (int i = 0; i < listRoleName.size(); i++) {
                cbbRole.addItem(listRoleName.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void copyImageIntoLandSoft() {
        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/images";
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdir();
            }
            dir += "/" + selectedPicture.getName();
            Path copied = Paths.get(dir);
            Path originalPath = Paths.get(selectedPicture.getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public panelAccounts() {
        initComponents();
        initTableAccounts();
        initGUIPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogRole = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        spinAccountID = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        cbbRole = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccounts = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        chooseBirthDay = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblImage = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        btnRole = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("AccountID:");

        spinAccountID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinAccountID.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Role:");

        cbbRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogRoleLayout = new javax.swing.GroupLayout(dialogRole.getContentPane());
        dialogRole.getContentPane().setLayout(dialogRoleLayout);
        dialogRoleLayout.setHorizontalGroup(
            dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dialogRoleLayout.createSequentialGroup()
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spinAccountID)
                    .addComponent(cbbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        dialogRoleLayout.setVerticalGroup(
            dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(spinAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnBack))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        setLayout(new java.awt.BorderLayout());

        tblAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        tblAccounts.setRowHeight(25);
        tblAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAccounts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Find:");

        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFindMouseClicked(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("AccountID:");

        txtAccountID.setEditable(false);
        txtAccountID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("First name:");

        txtFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Last name:");

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Gender:");

        buttonGroup1.add(radioMale);
        radioMale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioMale.setText("Male");

        buttonGroup1.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioFemale.setText("Female");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("BirthDay:");

        chooseBirthDay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Password:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Phone:");

        txtPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Address:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAddress.setLineWrap(true);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setOpaque(true);

        btnChooseImage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnChooseImage.setText("Choose Image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        btnRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_role.png"))); // NOI18N
        btnRole.setText("Role");
        btnRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoleActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnRole)
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioMale)
                        .addGap(18, 18, 18)
                        .addComponent(radioFemale))
                    .addComponent(txtAccountID)
                    .addComponent(txtFirstName)
                    .addComponent(txtLastName)
                    .addComponent(chooseBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(20, 20, 20)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtEmail)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImage))
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh)
                        .addComponent(btnAdd)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete))
                    .addComponent(btnRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(radioMale)
                            .addComponent(radioFemale))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(chooseBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnChooseImage))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initTableAccounts();
        initGUIPanel();

        txtAccountID.setText("");
        txtUsername.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        radioMale.setSelected(true);
        chooseBirthDay.setDate(null);
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");
        lblImage.setIcon(null);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseClicked
        findAccounts();
    }//GEN-LAST:event_txtFindMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String userName = txtUsername.getText();
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            boolean gender = false;
            String birthDay;
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String address = txtAddress.getText();
            String password = txtPassword.getText();
            if (userName.isEmpty() || userName.length() > 20) {
                JOptionPane.showMessageDialog(null, "Username not be empty or more than 20 character");
                txtUsername.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistUserName(userName)) {
                JOptionPane.showMessageDialog(null, "Username existed");
                txtUsername.requestFocus();
                return;
            }
            //first name, last name
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First name not be empty");
                txtFirstName.requestFocus();
                return;
            }
            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last name not be empty");
                txtLastName.requestFocus();
                return;
            }
            //Gender
            if (radioMale.isSelected()) {
                gender = true;
            } else {
                gender = false;
            }
            //Birth Day
            try {
                birthDay = new SimpleDateFormat("yyyy-MM-dd").format(chooseBirthDay.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose birthDay");
                chooseBirthDay.requestFocus();
                return;
            }
            //Email
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email not be empty !");
                txtEmail.requestFocus();
                return;
            }
            if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Email:  " + email + "  invalid. Exemple: ABC@gmail.com");
                txtEmail.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email existed");
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
                JOptionPane.showMessageDialog(null, "Phone number:  " + phoneNumber + "  invalid. Exemple: 0123456789");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistPhoneNumber(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "Phone number existed");
                txtPhoneNumber.requestFocus();
                return;
            }
            //Address
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address not be empty !");
                txtAddress.requestFocus();
                return;
            }
            //Password
            if (password.isEmpty() || password.length() > 20) {
                JOptionPane.showMessageDialog(null, "Password not be empty or more than 20 character");
                txtPassword.requestFocus();
                return;
            }
            //Image
            if (image == null) {
                JOptionPane.showMessageDialog(null, "Choose Image");
                return;
            }
            //Add new account
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Add new Account ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                copyImageIntoLandSoft();
                controller.AccountsController.addNewAccount(userName, firstName, lastName, gender, birthDay, email, phoneNumber, address, password, image);
                btnRefreshActionPerformed(evt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountsMouseClicked
        try {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);

            int index = tblAccounts.getSelectedRow();
            txtAccountID.setText(tblAccounts.getValueAt(index, 1).toString());
            txtUsername.setText(tblAccounts.getValueAt(index, 2).toString());
            txtFirstName.setText(tblAccounts.getValueAt(index, 3).toString());
            txtLastName.setText(tblAccounts.getValueAt(index, 4).toString());
            if (tblAccounts.getValueAt(index, 5).toString().equals("Male")) {
                radioMale.setSelected(true);
            } else {
                radioFemale.setSelected(true);
            }
            try {
                chooseBirthDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblAccounts.getValueAt(index, 6).toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            txtEmail.setText(tblAccounts.getValueAt(index, 7).toString());
            txtPhoneNumber.setText(tblAccounts.getValueAt(index, 8).toString());
            txtAddress.setText(tblAccounts.getValueAt(index, 9).toString());
//        txtPassword.setText(tblAccounts.getValueAt(index, 10).toString());
            byte[] img = controller.AccountsController.getListAccounts().get(index).getImage();
            ImageIcon icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
            lblImage.setIcon(icon);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblAccountsMouseClicked

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        try {
            String fileName = null;
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            chooser.setAcceptAllFileFilterUsed(true);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedPicture = chooser.getSelectedFile();
                fileName = selectedPicture.getAbsolutePath();
                ImageIcon icon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                lblImage.setIcon(icon);
            }
            if (result == JFileChooser.CANCEL_OPTION) {
                return;
            }
            File img = new File(fileName);
            FileInputStream fis = new FileInputStream(img);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(b)) != -1) {
                bos.write(b);
            }
            image = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int accountID = Integer.parseInt(txtAccountID.getText());
            String userName = txtUsername.getText();
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            boolean gender = false;
            String birthDay;
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String address = txtAddress.getText();
            String password = txtPassword.getText();
            if (userName.isEmpty() || userName.length() > 20) {
                JOptionPane.showMessageDialog(null, "Username not be empty or more than 20 character");
                txtUsername.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistUserNameOfAccountOrther(userName, accountID)) {
                JOptionPane.showMessageDialog(null, "Username existed");
                txtUsername.requestFocus();
                return;
            }
            //first name, last name
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First name not be empty");
                txtFirstName.requestFocus();
                return;
            }
            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last name not be empty");
                txtLastName.requestFocus();
                return;
            }
            //Gender
            if (radioMale.isSelected()) {
                gender = true;
            } else {
                gender = false;
            }
            //Birth Day
            try {
                birthDay = new SimpleDateFormat("yyyy-MM-dd").format(chooseBirthDay.getDate());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not choose birthDay");
                chooseBirthDay.requestFocus();
                return;
            }
            //Email
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email not be empty !");
                txtEmail.requestFocus();
                return;
            }
            if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(null, "Email:  " + email + "  invalid. Exemple: ABC@gmail.com");
                txtEmail.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistEmailOfAccountOrther(email, accountID)) {
                JOptionPane.showMessageDialog(null, "Email existed");
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
                JOptionPane.showMessageDialog(null, "Phone number:  " + phoneNumber + "  invalid. Exemple: 0123456789");
                txtPhoneNumber.requestFocus();
                return;
            }
            if (controller.AccountsController.checkExistPhoneNumberOfAccountOrther(phoneNumber, accountID)) {
                JOptionPane.showMessageDialog(null, "Phone number existed");
                txtPhoneNumber.requestFocus();
                return;
            }
            //Address
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address not be empty !");
                txtAddress.requestFocus();
                return;
            }
            //Password
            if (password.length() > 20) {
                JOptionPane.showMessageDialog(null, "Password no more than 20 character");
                txtPassword.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                password = tblAccounts.getValueAt(tblAccounts.getSelectedRow(), 10).toString();
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Update Account ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                controller.AccountsController.updateAccount(userName, firstName, lastName, gender, birthDay, email, phoneNumber, address, password, image, accountID);
                btnRefreshActionPerformed(evt);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int accountID = Integer.parseInt(txtAccountID.getText());
        int index = JOptionPane.showConfirmDialog(null, "Are you want to Delete Account ?", "Notification", JOptionPane.YES_NO_OPTION);
        if (index == JOptionPane.YES_OPTION) {
            try {
                controller.AccountsController.deleteAccount(accountID);
                btnRefreshActionPerformed(evt);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(panelAccounts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleActionPerformed
        dialogRole.setSize(400, 200);
        dialogRole.setVisible(true);
        dialogRole.setLocationRelativeTo(null);
        initGUIDialogRole();
    }//GEN-LAST:event_btnRoleActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            int accountID = Integer.parseInt(spinAccountID.getValue().toString());
            if (!controller.AccountsController.checkExistAccountID(accountID)) {
                JOptionPane.showMessageDialog(null, "Account not exist");
                spinAccountID.requestFocus();
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                String roleName = cbbRole.getSelectedItem().toString();
                int roleID = controller.AccountsController.getRoleIDWithRoleName(roleName);
                controller.AccountsController.insertRoleIDToAccount(roleID, accountID);
                btnRefreshActionPerformed(evt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dialogRole.dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRole;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbRole;
    private com.toedter.calendar.JDateChooser chooseBirthDay;
    private javax.swing.JDialog dialogRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JSpinner spinAccountID;
    private javax.swing.JTable tblAccounts;
    private javax.swing.JTextField txtAccountID;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
