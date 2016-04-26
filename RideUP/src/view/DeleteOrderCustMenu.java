/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;

/**
 *
 * @author NANON
 */
public class DeleteOrderCustMenu extends javax.swing.JPanel {

    /**
     * Creates new form DeleteOrderCustMenu
     */
    public DeleteOrderCustMenu() {
        initComponents();
    }

    public Object getBtnBack() {
        return btnBack;
    }

    public Object getBtnConfirmDelete() {
        return btnConfirmDelete;
    }
    
    public Object getBtnRefresh() {
        return btnRefresh;
    }
    
    public void setDeleteOrder(String s) {
        txDelete.setText(s);
    }
    
    public void setListOrder(String[] list) {
        listOrder.setListData(list);
    }
    
    public String getSelectedOrder() {
        return listOrder.getSelectedValue();
    }
    
    public void reset() {
        txDelete.setText("");
    }
    
    public void addAdapter(MouseAdapter e) {
        listOrder.addMouseListener(e);
    }
    
    public void addListener(ActionListener e) {
        btnBack.addActionListener(e);
        btnConfirmDelete.addActionListener(e);
        btnRefresh.addActionListener(e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listOrder = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txDelete = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnConfirmDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delorder.png"))); // NOI18N

        listOrder.setFont(new java.awt.Font("Cabin Condensed", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(listOrder);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DELETE");

        txDelete.setEditable(false);
        txDelete.setFont(new java.awt.Font("Cabin Condensed", 0, 12)); // NOI18N

        btnRefresh.setBackground(new java.awt.Color(230, 230, 230));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Refresh-16.png"))); // NOI18N
        btnRefresh.setText("REFRESH");

        btnConfirmDelete.setBackground(new java.awt.Color(230, 230, 230));
        btnConfirmDelete.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnConfirmDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Delete-16.png"))); // NOI18N
        btnConfirmDelete.setText("CONFIRM DELETE");

        btnBack.setBackground(new java.awt.Color(230, 230, 230));
        btnBack.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/Return-16.png"))); // NOI18N
        btnBack.setText("BACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txDelete))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmDelete)))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listOrder;
    private javax.swing.JTextField txDelete;
    // End of variables declaration//GEN-END:variables
}
