/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.DefaultTableModel;
import Code.*;
import java.util.List;
import ImplementationDB.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kashif khan
 */
public class DisplayItemUI extends javax.swing.JFrame {

    /**
     * Creates new form DisplayItemUI
     */ DefaultTableModel model;
     DefaultTableModel model2;
    public DisplayItemUI() {
        initComponents();
         model=(DefaultTableModel) jTable1.getModel();
         model2=(DefaultTableModel) jTable3.getModel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCb_Department = new javax.swing.JComboBox<>();
        jBtn_Department = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jBn_Display = new javax.swing.JButton();
        jCb_Type = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Display Items");
        setPreferredSize(new java.awt.Dimension(557, 629));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(1, 35, 53));

        jLabel1.setFont(new java.awt.Font("Magneto", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Display Item");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trolley (1).png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jPanel2.setBackground(new java.awt.Color(114, 114, 244));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item SKU", "Item Name", "Price", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jCb_Department.setModel(new javax.swing.DefaultComboBoxModel<>(SingletonPattern.getInstance().getSystem().getStore().getDepartments()));

        jBtn_Department.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Department.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtn_Department.setForeground(new java.awt.Color(0, 0, 0));
        jBtn_Department.setText("Display");
        jBtn_Department.setBorderPainted(false);
        jBtn_Department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_DepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jCb_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jBtn_Department))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCb_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Department", jPanel2);

        jPanel3.setBackground(new java.awt.Color(114, 114, 244));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item SKU", "Item Name", "Price", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jBn_Display.setBackground(new java.awt.Color(204, 204, 204));
        jBn_Display.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBn_Display.setForeground(new java.awt.Color(0, 0, 0));
        jBn_Display.setText("Display");
        jBn_Display.setBorderPainted(false);
        jBn_Display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBn_DisplayActionPerformed(evt);
            }
        });

        jCb_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Perishable", "Non-Perishable", "Fragile", "Non-Fragile" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jBn_Display, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBn_Display, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Type", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(57, 57, 57)
                .addComponent(jTabbedPane1)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBn_DisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBn_DisplayActionPerformed
        // TODO add your handling code here:
       model2.setRowCount(0);
      Integer option=jCb_Type.getSelectedIndex();
      //System.out.println(option);
      List<ItemQuantity> Itemarr=SingletonPattern.getInstance().getSystem().getStore().getItemQuantityList();
        for(int i=0;i<Itemarr.size();i++){
            if(option==1){
                if(Itemarr.get(i).getItem().isPerishable()==1)
                {
                    
                    model2.insertRow(jTable3.getRowCount(),new Object[]{
                    Itemarr.get(i).getItem().getSKU(),
                    Itemarr.get(i).getItem().getName(),
                    Itemarr.get(i).getItem().getPrice(),
                    Itemarr.get(i).getQuantity()
                        });
                }
            }
            if(option==2){
                if(Itemarr.get(i).getItem().isPerishable()==0)
                {
                    //System.out.println(Itemarr.get(i).getItem().getName());
                    model2.insertRow(jTable3.getRowCount(),new Object[]{
                    Itemarr.get(i).getItem().getSKU(),
                    Itemarr.get(i).getItem().getName(),
                    Itemarr.get(i).getItem().getPrice(),
                    Itemarr.get(i).getQuantity()
                        });
                }
            }
            if(option==3){
                if(Itemarr.get(i).getItem().getIsFragile()==1)
                {
                    //System.out.println(Itemarr.get(i).getItem().getName());
                    model2.insertRow(jTable3.getRowCount(),new Object[]{
                    Itemarr.get(i).getItem().getSKU(),
                    Itemarr.get(i).getItem().getName(),
                    Itemarr.get(i).getItem().getPrice(),
                    Itemarr.get(i).getQuantity()
                        });
                }
            }
            if(option==4){
                if(Itemarr.get(i).getItem().getIsFragile()==0)
                {
                    //System.out.println(Itemarr.get(i).getItem().getName());
                    model2.insertRow(jTable3.getRowCount(),new Object[]{
                    Itemarr.get(i).getItem().getSKU(),
                    Itemarr.get(i).getItem().getName(),
                    Itemarr.get(i).getItem().getPrice(),
                    Itemarr.get(i).getQuantity()
                        });
                }
            }
        }
    
             
    }//GEN-LAST:event_jBn_DisplayActionPerformed

    private void jBtn_DepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_DepartmentActionPerformed
        // TODO add your handling code here:
      model.setRowCount(0);
      String option=jCb_Department.getSelectedItem().toString();
      //System.out.println(option);
      List<ItemQuantity> Itemarr=SingletonPattern.getInstance().getSystem().getStore().getItemQuantityList();
        for(int i=0;i<Itemarr.size();i++){
            if(Itemarr.get(i).getItem().getDepartment().getDepartmentName().equals(option))
            {
                //System.out.println(Itemarr.get(i).getItem().getName());
                model.insertRow(jTable1.getRowCount(),new Object[]{
                Itemarr.get(i).getItem().getSKU(),
                Itemarr.get(i).getItem().getName(),
                Itemarr.get(i).getItem().getPrice(),
                Itemarr.get(i).getQuantity()
                    });
            }
        }
    }//GEN-LAST:event_jBtn_DepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayItemUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBn_Display;
    private javax.swing.JButton jBtn_Department;
    private javax.swing.JComboBox<String> jCb_Department;
    private javax.swing.JComboBox<String> jCb_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}