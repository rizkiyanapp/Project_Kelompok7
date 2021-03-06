/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author NANON
 */
public class CustomerMenu extends javax.swing.JPanel {

    /**
     * Creates new form CustomerMenu
     */
    public CustomerMenu() {
        initComponents();
    }

    public Object getBtnCourier() {
        return btnCourier;
    }

    public Object getBtnDelOrder() {
        return btnDelOrder;
    }

    public Object getBtnFeedback() {
        return btnFeedback;
    }

    public Object getBtnFoodCourier() {
        return btnFoodCourier;
    }

    public Object getBtnProfile() {
        return btnProfile;
    }

    public Object getBtnSignOut() {
        return btnSignOut;
    }

    public Object getBtnTransport() {
        return btnTransport;
    }

    public Object getBtnView() {
        return btnView;
    }
    
    public void addListener(ActionListener e) {
        btnCourier.addActionListener(e);
        btnDelOrder.addActionListener(e);
        btnFeedback.addActionListener(e);
        btnFoodCourier.addActionListener(e);
        btnProfile.addActionListener(e);
        btnSignOut.addActionListener(e);
        btnTransport.addActionListener(e);
        btnView.addActionListener(e);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTransport = new javax.swing.JButton();
        btnCourier = new javax.swing.JButton();
        btnFoodCourier = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        btnDelOrder = new javax.swing.JButton();
        btnFeedback = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cust.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Copyright© 2016");

        btnTransport.setBackground(new java.awt.Color(255, 255, 255));
        btnTransport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/trans.png"))); // NOI18N

        btnCourier.setBackground(new java.awt.Color(255, 255, 255));
        btnCourier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/crr.png"))); // NOI18N

        btnFoodCourier.setBackground(new java.awt.Color(255, 255, 255));
        btnFoodCourier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/fccr.png"))); // NOI18N

        btnProfile.setBackground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/pro.png"))); // NOI18N

        btnSignOut.setBackground(new java.awt.Color(255, 255, 255));
        btnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/sigo.png"))); // NOI18N

        btnDelOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnDelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/dor.png"))); // NOI18N

        btnFeedback.setBackground(new java.awt.Color(255, 255, 255));
        btnFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/fbc.png"))); // NOI18N

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/vor.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSignOut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProfile))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTransport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCourier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFoodCourier))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFeedback)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnView)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTransport)
                            .addComponent(btnCourier)
                            .addComponent(btnFoodCourier))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelOrder)
                            .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btnFeedback))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignOut)
                    .addComponent(btnProfile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourier;
    private javax.swing.JButton btnDelOrder;
    private javax.swing.JButton btnFeedback;
    private javax.swing.JButton btnFoodCourier;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnTransport;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
