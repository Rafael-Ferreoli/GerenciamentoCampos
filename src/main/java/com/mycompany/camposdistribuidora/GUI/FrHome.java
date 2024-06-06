/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.camposdistribuidora.GUI;

import com.mycompany.camposdistribuidora.GerenciadorCadastros;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class FrHome extends javax.swing.JFrame {

    private GerenciadorCadastros cadastro;
    
    public FrHome() {
        initComponents();
        jPasswordField_Password.setEnabled(false);
        jButton_Confirmar.setEnabled(true);
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
        jScrollBar1 = new javax.swing.JScrollBar();
        jSeparator2 = new javax.swing.JSeparator();
        jPasswordField_Password = new javax.swing.JPasswordField();
        jTextField_Login = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_Usuario = new javax.swing.JLabel();
        jLabel_Senha = new javax.swing.JLabel();
        jButton_Confirmar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniSAP");
        setMaximumSize(new java.awt.Dimension(214, 206));
        setMinimumSize(new java.awt.Dimension(214, 206));
        setResizable(false);

        jPasswordField_Password.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField_Password.setMaximumSize(new java.awt.Dimension(64, 22));
        jPasswordField_Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField_PasswordMouseClicked(evt);
            }
        });
        jPasswordField_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_PasswordActionPerformed(evt);
            }
        });

        jTextField_Login.setForeground(new java.awt.Color(0, 0, 0));
        jTextField_Login.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Login.setToolTipText("Login");
        jTextField_Login.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField_Login.setMaximumSize(new java.awt.Dimension(64, 22));
        jTextField_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_LoginMouseClicked(evt);
            }
        });
        jTextField_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LoginActionPerformed(evt);
            }
        });

        jLabel_Usuario.setText("Usuário:");

        jLabel_Senha.setText("Senha:");

        jButton_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-ok-20.png"))); // NOI18N
        jButton_Confirmar.setMaximumSize(new java.awt.Dimension(26, 50));
        jButton_Confirmar.setMinimumSize(new java.awt.Dimension(26, 50));
        jButton_Confirmar.setPreferredSize(new java.awt.Dimension(26, 50));
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConfirmarActionPerformed(evt);
            }
        });

        jButton_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-cancelar-20.png"))); // NOI18N
        jButton_Cancelar.setMaximumSize(new java.awt.Dimension(26, 50));
        jButton_Cancelar.setMinimumSize(new java.awt.Dimension(26, 50));
        jButton_Cancelar.setPreferredSize(new java.awt.Dimension(26, 50));
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Campos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("https://github.com/Rafael-Ferreoli");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Usuario)
                            .addComponent(jLabel_Senha))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jButton_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Usuario)
                            .addComponent(jTextField_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Senha)))
                    .addComponent(jButton_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Confirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        getAccessibleContext().setAccessibleName("CamposDistribuidora");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_LoginMouseClicked
        
    }//GEN-LAST:event_jTextField_LoginMouseClicked

    private void jPasswordField_PasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField_PasswordMouseClicked
        
    }//GEN-LAST:event_jPasswordField_PasswordMouseClicked

    private void jTextField_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LoginActionPerformed
        String usuarioDigitado = jTextField_Login.getText();
        jTextField_Login.setEnabled(false);
        jPasswordField_Password.setEnabled(true);
    }//GEN-LAST:event_jTextField_LoginActionPerformed

    private void jPasswordField_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_PasswordActionPerformed
        char[] senhaDigitada = jPasswordField_Password.getPassword();
        jPasswordField_Password.setEnabled(false);
        jButton_Confirmar.setEnabled(true);
    }//GEN-LAST:event_jPasswordField_PasswordActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Reiniciar Login?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            jTextField_Login.setText("");
            jPasswordField_Password.setText("");
            jButton_Confirmar.setEnabled(false);
            jTextField_Login.setEnabled(true);
        }
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConfirmarActionPerformed
        DlgMenu tela2 = new DlgMenu(true);
        tela2.setVisible(true);
    }//GEN-LAST:event_jButton_ConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Senha;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JPasswordField jPasswordField_Password;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField_Login;
    // End of variables declaration//GEN-END:variables
}
