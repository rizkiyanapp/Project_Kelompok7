/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author NANON
 */
public class MainMenu extends javax.swing.JPanel {

    /**
     * Creates new form MainMenu
     */
        
    public MainMenu() {
        initComponents();
    }
    
    public Object getBtnDelAcc() {
        return btnDelAcc;
    }

    public Object getBtnExit() {
        return btnExit;
    }

    public Object getBtnRegAcc() {
        return btnRegAcc;
    }

    public Object getBtnSignIn() {
        return btnSignIn;
    }

    public Object getBtnSignUp() {
        return btnSignUp;
    }
    
    public void addListener(ActionListener e) {
        btnDelAcc.addActionListener(e);
        btnExit.addActionListener(e);
        btnRegAcc.addActionListener(e);
        btnSignIn.addActionListener(e);
        btnSignUp.addActionListener(e);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnRegAcc = new javax.swing.JButton();
        btnDelAcc = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Copyright© 2016");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btnSignIn.setBackground(new java.awt.Color(255, 255, 255));
        btnSignIn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(27, 109, 193));
        btnSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/User Filled-16.png"))); // NOI18N
        btnSignIn.setText("SIGN IN");

        btnSignUp.setBackground(new java.awt.Color(255, 255, 255));
        btnSignUp.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(27, 109, 193));
        btnSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Add User Male Filled-16.png"))); // NOI18N
        btnSignUp.setText("SIGN UP");

        btnRegAcc.setBackground(new java.awt.Color(255, 255, 255));
        btnRegAcc.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRegAcc.setForeground(new java.awt.Color(27, 109, 193));
        btnRegAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Stack-16 (2).png"))); // NOI18N
        btnRegAcc.setText("REGISTERED ACCOUNT");

        btnDelAcc.setBackground(new java.awt.Color(255, 255, 255));
        btnDelAcc.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnDelAcc.setForeground(new java.awt.Color(27, 109, 193));
        btnDelAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Remove User Male Filled-16.png"))); // NOI18N
        btnDelAcc.setText("DELETE ACCOUNT");

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnExit.setForeground(new java.awt.Color(27, 109, 193));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Exit Filled-16.png"))); // NOI18N
        btnExit.setText("EXIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(161, 161, 161))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(89, 89, 89)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelAcc;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegAcc;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
