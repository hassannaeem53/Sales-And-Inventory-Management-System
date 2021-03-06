/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import ImplementationDB.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Code.*;
import javax.swing.JOptionPane;
/**
 *
 * @author HASSAN-NAEEM
 */
public class MainUI extends javax.swing.JFrame {


    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_LogINRight = new javax.swing.JPanel();
        jLabel_password = new javax.swing.JLabel();
        jTextField_UserName = new javax.swing.JTextField();
        jLabel_UserName = new javax.swing.JLabel();
        jPasswordField_LogInPass = new javax.swing.JPasswordField();
        jLabel_password1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel_interfacePic = new javax.swing.JLabel();
        jLabel_passwordPic = new javax.swing.JLabel();
        jLabel_Welcome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_LogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LogIn");
        setBackground(new java.awt.Color(0, 21, 65));
        setForeground(java.awt.Color.darkGray);
        setPreferredSize(new java.awt.Dimension(1147, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel_LogINRight.setBackground(new java.awt.Color(1, 35, 53));

        jLabel_password.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_password.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        jLabel_password.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_password.setText("Interface");

        jTextField_UserName.setText("35202-1234567-0");
        jTextField_UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_UserNameActionPerformed(evt);
            }
        });

        jLabel_UserName.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_UserName.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        jLabel_UserName.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName.setText("CNIC");

        jPasswordField_LogInPass.setText("tired");
        jPasswordField_LogInPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_LogInPassActionPerformed(evt);
            }
        });

        jLabel_password1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_password1.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        jLabel_password1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_password1.setText("Password");

        jComboBox1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cashier", "WareHouse Manager", "Store Manager" }));
        jComboBox1.setBorder(new javax.swing.border.MatteBorder(null));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user2.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel_interfacePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/man.png"))); // NOI18N
        jLabel_interfacePic.setText("jLabel2");

        jLabel_passwordPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/key.png"))); // NOI18N
        jLabel_passwordPic.setText("jLabel2");

        jLabel_Welcome.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Welcome.setFont(new java.awt.Font("Magneto", 0, 48)); // NOI18N
        jLabel_Welcome.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Welcome.setText("Welcome");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shop.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cs2c.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jButton_LogIn.setBackground(new java.awt.Color(204, 204, 255));
        jButton_LogIn.setForeground(new java.awt.Color(1, 1, 76));
        jButton_LogIn.setText("Log In");
        jButton_LogIn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 204), new java.awt.Color(255, 204, 204), null, null));
        jButton_LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_LogINRightLayout = new javax.swing.GroupLayout(jPanel_LogINRight);
        jPanel_LogINRight.setLayout(jPanel_LogINRightLayout);
        jPanel_LogINRightLayout.setHorizontalGroup(
            jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LogINRightLayout.createSequentialGroup()
                        .addComponent(jLabel_passwordPic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField_LogInPass, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                        .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                                        .addComponent(jLabel_interfacePic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_password, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                                        .addComponent(jLabel_Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jButton_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_LogINRightLayout.setVerticalGroup(
            jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_passwordPic)
                    .addComponent(jPasswordField_LogInPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel_LogINRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_interfacePic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(jPanel_LogINRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_LogINRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_LogINRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogInActionPerformed
        // TODO add your handling code here:
        int check=0;
        if(jComboBox1.getSelectedIndex()==1){
            
             SQL obj=new SQL();
             
        try(ResultSet rs=obj.GetCredentials();){
            while(rs.next()){
               if((jTextField_UserName.getText().equals(rs.getString(1))) && (jPasswordField_LogInPass.getText().equals(rs.getString(2))) && (rs.getInt(3)==1)){
                   new CashierMain().setVisible(true);
                   SingletonPattern.getInstance().getSystem().getStore().setCurrentCashier(SingletonPattern.getInstance().getSystem().getStore().getCashierFromCnic(jTextField_UserName.getText()));
                   check=1;
               } 
                 
                
            }
            if(check==0){
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
        catch(SQLException e){
             e.printStackTrace();
        }
        }
        if(jComboBox1.getSelectedIndex()==3){
          
             SQL obj=new SQL();
        try(ResultSet rs=obj.GetCredentials();){
            while(rs.next()){
               if((jTextField_UserName.getText().equals(rs.getString(1))) && (jPasswordField_LogInPass.getText().equals(rs.getString(2))) && (rs.getInt(3)==3)){
                     new StoreManagerMain().setVisible(true);
                     check=1;
               }   
              
                 
                
            }
              if(check==0){
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
        catch(SQLException e){
             e.printStackTrace();
        }
        }
        if(jComboBox1.getSelectedIndex()==2){
       
        SQL obj=new SQL();
        try(ResultSet rs=obj.GetCredentials();){
            while(rs.next()){
               if((jTextField_UserName.getText().equals(rs.getString(1))) && (jPasswordField_LogInPass.getText().equals(rs.getString(2))) && (rs.getInt(3)==2)){
                    new WarehouseManagerMain().setVisible(true);
                    check=1;
               } 
                 
                
            }
              if(check==0){
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
        catch(SQLException e){
             e.printStackTrace();
        }
        }
         


        
    }//GEN-LAST:event_jButton_LogInActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jPasswordField_LogInPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_LogInPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_LogInPassActionPerformed

    private void jTextField_UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_UserNameActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
   
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
                System.out.println("Screen closed");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        ///////////////////////////////////
        //////////////////////////////////
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_LogIn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_UserName;
    private javax.swing.JLabel jLabel_Welcome;
    private javax.swing.JLabel jLabel_interfacePic;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JLabel jLabel_password1;
    private javax.swing.JLabel jLabel_passwordPic;
    private javax.swing.JPanel jPanel_LogINRight;
    private javax.swing.JPasswordField jPasswordField_LogInPass;
    private javax.swing.JTextField jTextField_UserName;
    // End of variables declaration//GEN-END:variables
}
