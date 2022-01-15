/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view;

import DesafioPubFuture.controller.ReceitaController;
import DesafioPubFuture.dao.ConnectionMVC;
import DesafioPubFuture.dao.ExceptionDAO;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class CadastroReceita extends javax.swing.JFrame {

    /**
     * Creates new form CadastroReceita
     */
    public CadastroReceita() throws SQLException{
        initComponents();
        atualizaTipoReceita();
        atualizaConta();
    }
    public void atualizaTipoReceita() throws SQLException{
        String sql = "SELECT * FROM TipoReceita;";
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                    jComboBoxTipoReceita.addItem(rs.getString("Nome"));
            }
        conn.close();
        stmt.close();
    }
    
    public void atualizaConta() throws SQLException{
        String sql = "SELECT * FROM Conta;";
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                jComboBoxConta.addItem(rs.getString("Nome"));
            }
        conn.close();
        stmt.close();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonCancela = new javax.swing.JButton();
        jButtonConsulta = new javax.swing.JButton();
        jButtonSalva = new javax.swing.JButton();
        jButtonTipoReceita = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jFormattedValor = new javax.swing.JFormattedTextField();
        jFormattedRecebimento = new javax.swing.JFormattedTextField();
        jFormattedEsperado = new javax.swing.JFormattedTextField();
        jComboBoxTipoReceita = new javax.swing.JComboBox<>();
        jComboBoxConta = new javax.swing.JComboBox<>();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Valor:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Conta:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Descrição:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Data de Recebimento:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Data Esperada de Recebimento:");

        jButtonCancela.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancela.setText("Cancelar");
        jButtonCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaActionPerformed(evt);
            }
        });

        jButtonConsulta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonConsulta.setText("Consultar");

        jButtonSalva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalva.setText("Salvar");
        jButtonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvaActionPerformed(evt);
            }
        });

        jButtonTipoReceita.setText("Novo");

        jButton5.setText("Nova");

        jFormattedValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####.00"))));
        jFormattedValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedValor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        try {
            jFormattedRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedRecebimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedRecebimento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        try {
            jFormattedEsperado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedEsperado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedEsperado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jComboBoxTipoReceita.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxTipoReceita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTipoReceitaMouseClicked(evt);
            }
        });

        jComboBoxConta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxContaMouseClicked(evt);
            }
        });

        jTextFieldDescricao.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextFieldDescricao.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipoReceita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBoxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFormattedValor, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButtonTipoReceita, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonCancela)
                        .addGap(66, 66, 66)
                        .addComponent(jButtonConsulta)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedEsperado, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jFormattedRecebimento)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jButtonSalva)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTipoReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTipoReceita))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancela)
                    .addComponent(jButtonConsulta)
                    .addComponent(jButtonSalva))
                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Nova Receita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jComboBoxTipoReceitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoReceitaMouseClicked
        jComboBoxTipoReceita.removeAllItems();
        try {
            atualizaTipoReceita();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxTipoReceitaMouseClicked

    private void jComboBoxContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContaMouseClicked
        jComboBoxConta.removeAllItems();
        try {
            atualizaConta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxContaMouseClicked

    private void jButtonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvaActionPerformed
        ReceitaController receitaController = new ReceitaController();
        Double valor = Double.parseDouble(jFormattedValor.getText().replace(",", "."));
        Integer tipoDespesa = jComboBoxTipoReceita.getSelectedIndex()+1;
        Integer conta = jComboBoxConta.getSelectedIndex()+1;
        String descricao = jTextFieldDescricao.getText();
        String dataRecebimento = jFormattedRecebimento.getText();
        String dataEsperado = jFormattedEsperado.getText();
        try {
            receitaController.cadastraReceita(valor, tipoDespesa, conta, descricao, dataRecebimento, dataEsperado);
        } catch (ExceptionDAO | SQLException | ParseException ex) {
            Logger.getLogger(CadastroReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFormattedEsperado.setText("");
        jFormattedRecebimento.setText("");
        jFormattedValor.setText("");
        jTextFieldDescricao.setText("");
        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
    }//GEN-LAST:event_jButtonSalvaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroReceita().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroReceita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonCancela;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonSalva;
    private javax.swing.JButton jButtonTipoReceita;
    private javax.swing.JComboBox<String> jComboBoxConta;
    private javax.swing.JComboBox<String> jComboBoxTipoReceita;
    private javax.swing.JFormattedTextField jFormattedEsperado;
    private javax.swing.JFormattedTextField jFormattedRecebimento;
    private javax.swing.JFormattedTextField jFormattedValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables
}
