/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Property;

/**
 *
 * @author TAI
 */
public final class panelProperty extends javax.swing.JPanel {

    /**
     * Creates new form panelProperty
     */
    void initTableProperty() {
        try {
            Vector vCol = new Vector();
            vCol.add("No.");
            vCol.add("PropertyID");
            vCol.add("TypeID");
            vCol.add("Square meter");
            vCol.add("Price");
            vCol.add("OwnerID");
            vCol.add("Address");
            vCol.add("Floor");
            vCol.add("Bedrooms");
            vCol.add("Bathrooms");
            vCol.add("Balcony");
            vCol.add("Pool");
            vCol.add("Garage");
            vCol.add("Desciption");

            Vector vData = new Vector();
            List<Property> listProperty = controller.PropertyController.getListProperty();
            int countRow = 0;
            for (Property property : listProperty) {
                Vector vTemp = new Vector();
                countRow++;
                vTemp.add(countRow);
                vTemp.add(property.getPropertyID());
                vTemp.add(property.getTypeID());
                vTemp.add(property.getSquareMeter());
                vTemp.add(property.getPrice());
                vTemp.add(property.getOwnerID());
                vTemp.add(property.getAddress());
                vTemp.add(property.getFloor());
                vTemp.add(property.getBedrooms());
                vTemp.add(property.getBathrooms());
                if (property.isBalcony()) {
                    vTemp.add("YES");
                } else {
                    vTemp.add("NO");
                }
                if (property.isPool()) {
                    vTemp.add("YES");
                } else {
                    vTemp.add("NO");
                }
                if (property.isGarage()) {
                    vTemp.add("YES");
                } else {
                    vTemp.add("NO");
                }

                vTemp.add(property.getDesciption());
                vData.add(vTemp);
            }
            DefaultTableModel model = new DefaultTableModel(vData, vCol);
            tblProperty.setModel(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void initGUIPanelProperty() {
        try {
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnDetailDescription.setEnabled(false);
            cbbTypeName.removeAllItems();
            List<String> listTypeName = controller.PropertyController.getTypeName();
            for (int i = 0; i < listTypeName.size(); i++) {
                cbbTypeName.addItem(listTypeName.get(i));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void findProperty() {
        TableRowSorter rowSorter = new TableRowSorter(tblProperty.getModel());
        tblProperty.setRowSorter(rowSorter);
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

    public panelProperty() {
        initComponents();
        initTableProperty();
        initGUIPanelProperty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDetailDescription = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDetailDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProperty = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtPropertyID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDetailDescription = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spinBedrooms = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spinBathrooms = new javax.swing.JSpinner();
        checkBalcony = new javax.swing.JCheckBox();
        checkPool = new javax.swing.JCheckBox();
        checkGarage = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtSquareMeter = new javax.swing.JTextField();
        spinOwnerID = new javax.swing.JSpinner();
        cbbTypeName = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        spinFloor = new javax.swing.JSpinner();

        txtDetailDescription.setColumns(20);
        txtDetailDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDetailDescription.setLineWrap(true);
        txtDetailDescription.setRows(5);
        txtDetailDescription.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtDetailDescription);

        javax.swing.GroupLayout dialogDetailDescriptionLayout = new javax.swing.GroupLayout(dialogDetailDescription.getContentPane());
        dialogDetailDescription.getContentPane().setLayout(dialogDetailDescriptionLayout);
        dialogDetailDescriptionLayout.setHorizontalGroup(
            dialogDetailDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        dialogDetailDescriptionLayout.setVerticalGroup(
            dialogDetailDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        setLayout(new java.awt.BorderLayout());

        tblProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
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
        tblProperty.setRowHeight(25);
        tblProperty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPropertyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProperty);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        jLabel1.setText("Find:");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFindMouseClicked(evt);
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

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("PropertyID:");

        txtPropertyID.setEditable(false);
        txtPropertyID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Type name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Square Meter:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Price:");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("OwnerID:");

        btnDetailDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDetailDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_show.png"))); // NOI18N
        btnDetailDescription.setText("Detail Desciption");
        btnDetailDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailDescriptionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Bedrooms:");

        spinBedrooms.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinBedrooms.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Bathrooms:");

        spinBathrooms.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinBathrooms.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        checkBalcony.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkBalcony.setText("Balcony");

        checkPool.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkPool.setText("Pool");

        checkGarage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkGarage.setText("Garage");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Address:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAddress.setLineWrap(true);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane3.setViewportView(txtDescription);

        txtSquareMeter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spinOwnerID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinOwnerID.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        cbbTypeName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTypeName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbTypeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTypeNameMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Floor:");

        spinFloor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinFloor.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPropertyID)
                                    .addComponent(cbbTypeName, 0, 227, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtSquareMeter))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrice)
                                            .addComponent(spinOwnerID))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinBedrooms))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinBathrooms))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBalcony)
                                    .addComponent(checkPool)
                                    .addComponent(checkGarage)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetailDescription)))
                .addGap(50, 50, 50))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel8, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh)
                    .addComponent(btnDetailDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(spinFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(spinBathrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkPool))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtSquareMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spinBedrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkGarage))))
                            .addComponent(checkBalcony))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(spinOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(0, 148, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPropertyMouseClicked
        try {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnDetailDescription.setEnabled(true);

            int index = tblProperty.getSelectedRow();

            String propertyID = tblProperty.getValueAt(index, 1).toString();
            String typeID = tblProperty.getValueAt(index, 2).toString();
            String squareMeter = tblProperty.getValueAt(index, 3).toString();
            String price = tblProperty.getValueAt(index, 4).toString();
            int ownerID = Integer.parseInt(tblProperty.getValueAt(index, 5).toString());
            String address = tblProperty.getValueAt(index, 6).toString();

            int floor = Integer.parseInt(tblProperty.getValueAt(index, 7).toString());
            int bedrooms = Integer.parseInt(tblProperty.getValueAt(index, 8).toString());
            int bathrooms = Integer.parseInt(tblProperty.getValueAt(index, 9).toString());
            String balcony = tblProperty.getValueAt(index, 10).toString();
            String pool = tblProperty.getValueAt(index, 11).toString();
            String garage = tblProperty.getValueAt(index, 12).toString();
            String desciption = tblProperty.getValueAt(index, 13).toString();

            txtPropertyID.setText(propertyID);

            //Nhận type name
            cbbTypeName.removeAllItems();
            List<String> listTypeName = controller.PropertyController.getTypeNameWithID(typeID);
            for (int i = 0; i < listTypeName.size(); i++) {
                cbbTypeName.addItem(listTypeName.get(0));
            }

            txtSquareMeter.setText(squareMeter);
            txtPrice.setText(price);
            spinOwnerID.setValue(ownerID);
            txtAddress.setText(address);
            spinFloor.setValue(floor);
            spinBedrooms.setValue(bedrooms);
            spinBathrooms.setValue(bathrooms);

            if (balcony.equals("YES")) {
                checkBalcony.setSelected(true);
            } else {
                checkBalcony.setSelected(false);
            }
            if (pool.equals("YES")) {
                checkPool.setSelected(true);
            } else {
                checkPool.setSelected(false);
            }
            if (garage.equals("YES")) {
                checkGarage.setSelected(true);
            } else {
                checkGarage.setSelected(false);
            }
            txtDescription.setText(desciption);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPropertyMouseClicked

    private void txtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseClicked
        findProperty();
    }//GEN-LAST:event_txtFindMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initTableProperty();
        initGUIPanelProperty();

        txtPropertyID.setText("");
        txtSquareMeter.setText("");
        txtPrice.setText("");
        spinOwnerID.setValue(0);
        txtAddress.setText("");
        spinFloor.setValue(0);
        spinBedrooms.setValue(0);
        spinBathrooms.setValue(0);
        checkBalcony.setSelected(false);
        checkPool.setSelected(false);
        checkGarage.setSelected(false);
        txtDescription.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            //Lấy typeID theo type name đang chọn
            String typeName = cbbTypeName.getSelectedItem().toString();
            int typeID = controller.PropertyController.getTypeID(typeName);

            String squareMeter = txtSquareMeter.getText();
            String price = txtPrice.getText();
            String address = txtAddress.getText();
            int ownerID = Integer.parseInt(spinOwnerID.getValue().toString());

            int floor = Integer.parseInt(spinFloor.getValue().toString());
            int bedrooms = Integer.parseInt(spinBedrooms.getValue().toString());
            int bathrooms = Integer.parseInt(spinBathrooms.getValue().toString());
            boolean balcony = checkBalcony.isSelected();
            boolean pool = checkPool.isSelected();
            boolean garage = checkGarage.isSelected();
            String description = txtDescription.getText();

            if (squareMeter.isEmpty() || squareMeter.length() > 10) {
                JOptionPane.showMessageDialog(null, "Square meter not be empty or more than 10 character !");
                txtSquareMeter.requestFocus();
                return;
            }
            try {
                Double.parseDouble(squareMeter);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Square meter must be a number");
                txtSquareMeter.requestFocus();
                return;
            }
            if (price.isEmpty() || price.length() > 20) {
                JOptionPane.showMessageDialog(null, "Price not be empty or more than 50 character !");
                txtPrice.requestFocus();
                return;
            }
            try {
                Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price must be a number");
                txtPrice.requestFocus();
                return;
            }

            //Kiểm tra OwnerID có tồn tại
            if (!controller.PropertyController.checkExistOwnerID(ownerID)) {
                JOptionPane.showMessageDialog(null, "OwnerID not exist !");
                spinOwnerID.requestFocus();
                return;
            }

            if (address.isEmpty() || address.length() > 50) {
                JOptionPane.showMessageDialog(null, "Address not be empty or more than 50 character !");
                txtAddress.requestFocus();
                return;
            }
            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Description not be empty!");
                txtDescription.requestFocus();
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Add new property ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                //Thực hiện add new Property
                controller.PropertyController.addNewProperty(typeID, squareMeter, price, ownerID, address, floor, bedrooms, bathrooms, balcony, pool, garage, description);
                btnRefreshActionPerformed(evt);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            //Lấy typeID theo type name đang chọn
            int propertyID = Integer.parseInt(txtPropertyID.getText());

            String typeName = cbbTypeName.getSelectedItem().toString();
            int typeID = controller.PropertyController.getTypeID(typeName);

            String squareMeter = txtSquareMeter.getText();
            String price = txtPrice.getText();
            String address = txtAddress.getText();
            int ownerID = Integer.parseInt(spinOwnerID.getValue().toString());
            int floor = Integer.parseInt(spinFloor.getValue().toString());
            int bedrooms = Integer.parseInt(spinBedrooms.getValue().toString());
            int bathrooms = Integer.parseInt(spinBathrooms.getValue().toString());
            boolean balcony = checkBalcony.isSelected();
            boolean pool = checkPool.isSelected();
            boolean garage = checkGarage.isSelected();
            String description = txtDescription.getText();

            if (squareMeter.isEmpty() || squareMeter.length() > 10) {
                JOptionPane.showMessageDialog(null, "Square meter not be empty or more than 10 character !");
                txtSquareMeter.requestFocus();
                return;
            }
            try {
                Double.parseDouble(squareMeter);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Square meter must be a number");
                txtSquareMeter.requestFocus();
                return;
            }
            if (price.isEmpty() || price.length() > 20) {
                JOptionPane.showMessageDialog(null, "Price not be empty or more than 50 character !");
                txtPrice.requestFocus();
                return;
            }
            try {
                Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price must be a number");
                txtPrice.requestFocus();
                return;
            }

            //Kiểm tra OwnerID có tồn tại
            if (!controller.PropertyController.checkExistOwnerID(ownerID)) {
                JOptionPane.showMessageDialog(null, "OwnerID not exist !");
                spinOwnerID.requestFocus();
                return;
            }

            if (address.isEmpty() || address.length() > 50) {
                JOptionPane.showMessageDialog(null, "Address not be empty or more than 50 character !");
                txtAddress.requestFocus();
                return;
            }
            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Description not be empty!");
                txtDescription.requestFocus();
                return;
            }
            int index = JOptionPane.showConfirmDialog(null, "Are you want to Update property ?", "Notification", JOptionPane.YES_NO_OPTION);
            if (index == JOptionPane.YES_OPTION) {
                //Thực hiện update Property
                Property property = new Property(propertyID, typeID, squareMeter, price, ownerID, address, floor, bedrooms, bathrooms, balcony, pool, garage, description);
                controller.PropertyController.updateProperty(property);
                btnRefreshActionPerformed(evt);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbbTypeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTypeNameMouseClicked
        try {
            cbbTypeName.removeAllItems();
            List<String> listTypeName = controller.PropertyController.getTypeName();
            for (int i = 0; i < listTypeName.size(); i++) {
                cbbTypeName.addItem(listTypeName.get(i));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbTypeNameMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int propertyID = Integer.parseInt(txtPropertyID.getText());
        int index = JOptionPane.showConfirmDialog(null, "Are you want to Delete property ?", "Notification", JOptionPane.YES_NO_OPTION);
        if (index == JOptionPane.YES_OPTION) {
            try {
                controller.PropertyController.deleteProperty(propertyID);
                btnRefreshActionPerformed(evt);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(panelProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDetailDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailDescriptionActionPerformed
        dialogDetailDescription.setVisible(true);
        dialogDetailDescription.setSize(400, 400);
        dialogDetailDescription.setLocationRelativeTo(null);
        dialogDetailDescription.setResizable(false);
        txtDetailDescription.setText(txtDescription.getText());
    }//GEN-LAST:event_btnDetailDescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetailDescription;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbTypeName;
    private javax.swing.JCheckBox checkBalcony;
    private javax.swing.JCheckBox checkGarage;
    private javax.swing.JCheckBox checkPool;
    private javax.swing.JDialog dialogDetailDescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinBathrooms;
    private javax.swing.JSpinner spinBedrooms;
    private javax.swing.JSpinner spinFloor;
    private javax.swing.JSpinner spinOwnerID;
    private javax.swing.JTable tblProperty;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtDetailDescription;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPropertyID;
    private javax.swing.JTextField txtSquareMeter;
    // End of variables declaration//GEN-END:variables
}
