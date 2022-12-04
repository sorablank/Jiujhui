/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author maher
 */
public class StudentLoginPage extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public StudentLoginPage() {
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

        jPanel1 = new javax.swing.JPanel();
        logIn = new javax.swing.JButton();
        passwordField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(null);

        logIn.setBackground(new java.awt.Color(133, 0, 0));
        logIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logIn.setForeground(new java.awt.Color(255, 255, 255));
        logIn.setText("Log In");
        logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInActionPerformed(evt);
            }
        });
        jPanel1.add(logIn);
        logIn.setBounds(780, 600, 360, 90);
        jPanel1.add(passwordField);
        passwordField.setBounds(780, 492, 360, 90);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usernameField);
        usernameField.setBounds(780, 354, 360, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginImage.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        // TODO add your handling code here:
        if(usernameField.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Username Required");
        usernameField.requestFocus();
        return;
        }
        
        if(passwordField.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Password Required");
        passwordField.requestFocus();
        return;
        }
        
        
        String present;
        present = "0";
        String usernameInput = usernameField.getText();
        String passwordInput = passwordField.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection StudentConnection = DriverManager.getConnection("jdbc:mysql://192.168.161.158:3306/finalproject","root", "");
            Statement StudentStatement = (Statement) StudentConnection.createStatement();
            String StudentSql = ("Select * from student_info");

            ResultSet StudentResult = StudentStatement.executeQuery(StudentSql);
            while(StudentResult.next())
            {
                String usernameTable = StudentResult.getString("username");
                String passwordTable = StudentResult.getString("password");

                if(usernameInput.equals(usernameTable)&& passwordInput.equals(passwordTable))
                {
                    present = "1";
                    break;
                }
            }

            if(present.equals("1"))
            {
                new StudentHomePage().setVisible(true);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong credentials. Please check credentials and try again");
            }
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error");
        }
    
        
    }//GEN-LAST:event_logInActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logIn;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
