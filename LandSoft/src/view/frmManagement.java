/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author TAI
 */
public final class frmManagement extends javax.swing.JFrame {

    /**
     * Creates new form frmHome
     */
    void initGUIManagement() {
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);

        panelContent.add(new panelProperty(), "panelProperty");
        panelContent.add(new panelOwners(), "panelOwners");
        panelContent.add(new panelCustomers(), "panelCustomers");
        panelContent.add(new panelPropertysType(), "panelPropertysType");

        //Icon title
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/icon_Login.png"));
        this.setIconImage(icon.getImage());
    }

    public frmManagement() {
        initComponents();
        initGUIManagement();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPropertys = new javax.swing.JLabel();
        lblOwners = new javax.swing.JLabel();
        lblCustomers = new javax.swing.JLabel();
        lblPropertysType = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management");
        setPreferredSize(new java.awt.Dimension(1024, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1305, 80));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo-Home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1236, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        lblPropertys.setBackground(new java.awt.Color(102, 102, 102));
        lblPropertys.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPropertys.setForeground(new java.awt.Color(255, 255, 255));
        lblPropertys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPropertys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_property.png"))); // NOI18N
        lblPropertys.setText("Propertys");
        lblPropertys.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblPropertys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPropertys.setOpaque(true);
        lblPropertys.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblPropertys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPropertysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPropertysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPropertysMouseExited(evt);
            }
        });

        lblOwners.setBackground(new java.awt.Color(102, 102, 102));
        lblOwners.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOwners.setForeground(new java.awt.Color(255, 255, 255));
        lblOwners.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOwners.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_owner.png"))); // NOI18N
        lblOwners.setText("Owners");
        lblOwners.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblOwners.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblOwners.setOpaque(true);
        lblOwners.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblOwners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOwnersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOwnersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOwnersMouseExited(evt);
            }
        });

        lblCustomers.setBackground(new java.awt.Color(102, 102, 102));
        lblCustomers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCustomers.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_customer.png"))); // NOI18N
        lblCustomers.setText("Customers");
        lblCustomers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCustomers.setOpaque(true);
        lblCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCustomersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCustomersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCustomersMouseExited(evt);
            }
        });

        lblPropertysType.setBackground(new java.awt.Color(102, 102, 102));
        lblPropertysType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPropertysType.setForeground(new java.awt.Color(255, 255, 255));
        lblPropertysType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPropertysType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_type.png"))); // NOI18N
        lblPropertysType.setText("Propertys type");
        lblPropertysType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblPropertysType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPropertysType.setOpaque(true);
        lblPropertysType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblPropertysType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPropertysTypeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPropertysTypeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPropertysTypeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPropertys, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(lblOwners, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(lblCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(lblPropertysType, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblPropertys, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblOwners, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPropertysType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 368, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        panelContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPropertysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysMouseEntered
        lblPropertys.setBackground(Color.blue);
    }//GEN-LAST:event_lblPropertysMouseEntered

    private void lblPropertysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysMouseExited
        lblPropertys.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblPropertysMouseExited

    private void lblOwnersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOwnersMouseEntered
        lblOwners.setBackground(Color.blue);
    }//GEN-LAST:event_lblOwnersMouseEntered

    private void lblOwnersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOwnersMouseExited
        lblOwners.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblOwnersMouseExited

    private void lblCustomersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomersMouseEntered
        lblCustomers.setBackground(Color.blue);
    }//GEN-LAST:event_lblCustomersMouseEntered

    private void lblCustomersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomersMouseExited
        lblCustomers.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblCustomersMouseExited

    private void lblPropertysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysMouseClicked
        CardLayout layout = (CardLayout) panelContent.getLayout();
        layout.show(panelContent, "panelProperty");
    }//GEN-LAST:event_lblPropertysMouseClicked

    private void lblOwnersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOwnersMouseClicked
        CardLayout layout = (CardLayout) panelContent.getLayout();
        layout.show(panelContent, "panelOwners");
    }//GEN-LAST:event_lblOwnersMouseClicked

    private void lblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomersMouseClicked
        CardLayout layout = (CardLayout) panelContent.getLayout();
        layout.show(panelContent, "panelCustomers");
    }//GEN-LAST:event_lblCustomersMouseClicked

    private void lblPropertysTypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysTypeMouseEntered
        lblPropertysType.setBackground(Color.blue);
    }//GEN-LAST:event_lblPropertysTypeMouseEntered

    private void lblPropertysTypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysTypeMouseExited
        lblPropertysType.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblPropertysTypeMouseExited

    private void lblPropertysTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPropertysTypeMouseClicked
        CardLayout layout = (CardLayout) panelContent.getLayout();
        layout.show(panelContent, "panelPropertysType");
    }//GEN-LAST:event_lblPropertysTypeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCustomers;
    private javax.swing.JLabel lblOwners;
    private javax.swing.JLabel lblPropertys;
    private javax.swing.JLabel lblPropertysType;
    private javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables
}
