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
import javax.swing.JComponent;
import javax.swing.RowFilter;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
        cbbTypeName = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSquareMeter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOwnerID = new javax.swing.JTextField();
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

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_delete.png"))); // NOI18N
        btnDelete.setText("Delete");

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

        cbbTypeName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbTypeName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Square Meter:");

        txtSquareMeter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Price(VND):");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("OwnerID:");

        txtOwnerID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnDetailDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDetailDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_show.png"))); // NOI18N
        btnDetailDescription.setText("Detail Desciption");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Bedrooms:");

        spinBedrooms.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Bathrooms:");

        spinBathrooms.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane3.setViewportView(txtDescription);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSquareMeter)
                                    .addComponent(txtPrice)
                                    .addComponent(txtOwnerID))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(checkBalcony)
                                .addGap(18, 18, 18)
                                .addComponent(checkPool)
                                .addGap(18, 18, 18)
                                .addComponent(checkGarage))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinBedrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinBathrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
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

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9});

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(spinBedrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(spinBathrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSquareMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBalcony)
                            .addComponent(checkPool)
                            .addComponent(checkGarage))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addContainerGap(150, Short.MAX_VALUE))
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
            String ownerID = tblProperty.getValueAt(index, 5).toString();
            String address = tblProperty.getValueAt(index, 6).toString();
            int bedrooms = Integer.parseInt(tblProperty.getValueAt(index, 7).toString());
            int bathrooms = Integer.parseInt(tblProperty.getValueAt(index, 8).toString());
            String balcony = tblProperty.getValueAt(index, 9).toString();
            String pool = tblProperty.getValueAt(index, 10).toString();
            String garage = tblProperty.getValueAt(index, 11).toString();
            String desciption = tblProperty.getValueAt(index, 12).toString();

            txtPropertyID.setText(propertyID);
            cbbTypeName.removeAllItems();
            List<String> listTypeName = controller.PropertyController.getTypeNameWithID(typeID);
            for (int i = 0; i < listTypeName.size(); i++) {
                cbbTypeName.addItem(listTypeName.get(i));
            }

            txtSquareMeter.setText(squareMeter);
            txtPrice.setText(price);
            txtOwnerID.setText(ownerID);
            txtAddress.setText(address);
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
        cbbTypeName.removeAllItems();
        txtSquareMeter.setText("");
        txtPrice.setText("");
        txtOwnerID.setText("");
        txtAddress.setText("");
        spinBedrooms.setValue(0);
        spinBathrooms.setValue(0);
        checkBalcony.setSelected(false);
        checkPool.setSelected(false);
        checkGarage.setSelected(false);
        txtDescription.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
    }//GEN-LAST:event_btnAddActionPerformed


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinBathrooms;
    private javax.swing.JSpinner spinBedrooms;
    private javax.swing.JTable tblProperty;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtOwnerID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPropertyID;
    private javax.swing.JTextField txtSquareMeter;
    // End of variables declaration//GEN-END:variables
}
