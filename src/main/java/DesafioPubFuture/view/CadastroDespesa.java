/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view;

import DesafioPubFuture.controller.DespesaController;
import DesafioPubFuture.dao.ConnectionMVC;
import DesafioPubFuture.dao.ExceptionDAO;
import java.lang.reflect.Executable;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class CadastroDespesa extends javax.swing.JFrame {

    /**
     * Creates new form CadastroDespesa
     */
    public CadastroDespesa()throws SQLException {
        initComponents();
        atualizaConta();
        atualizaTipoDespesa();
    }

    public void atualizaTipoDespesa() throws SQLException{
        String sql = "SELECT * FROM TipoDespesa;";
        Connection conn = new ConnectionMVC().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                    jComboBoxTipoDespesa.addItem(rs.getString("Nome"));
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonSalva = new javax.swing.JButton();
        jButtonConsulta = new javax.swing.JButton();
        jButtonCancela = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedValor = new javax.swing.JFormattedTextField();
        jComboBoxTipoDespesa = new javax.swing.JComboBox<>();
        jComboBoxConta = new javax.swing.JComboBox<>();
        jTextFieldDescricao = new javax.swing.JTextField();
        jFormattedPagamento = new javax.swing.JFormattedTextField();
        jFormattedEsperado = new javax.swing.JFormattedTextField();
        jButtonTipoDespesa = new javax.swing.JButton();
        jButtonConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Nova Despesa");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSalva.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalva.setText("Salvar");
        jButtonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvaActionPerformed(evt);
            }
        });

        jButtonConsulta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonConsulta.setText("Consultar");

        jButtonCancela.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancela.setText("Cancelar");
        jButtonCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Valor:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Conta:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Descrição:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Data do Pagamento");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Data Esperada de Pagamento:");

        jFormattedValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####.00"))));
        jFormattedValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedValor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jComboBoxTipoDespesa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxTipoDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTipoDespesaMouseClicked(evt);
            }
        });
        jComboBoxTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDespesaActionPerformed(evt);
            }
        });

        jComboBoxConta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxContaMouseClicked(evt);
            }
        });

        jTextFieldDescricao.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        try {
            jFormattedPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedPagamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedPagamento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        try {
            jFormattedEsperado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedEsperado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedEsperado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButtonTipoDespesa.setText("Novo");
        jButtonTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoDespesaActionPerformed(evt);
            }
        });

        jButtonConta.setText("Nova");
        jButtonConta.setMargin(new java.awt.Insets(2, 14, 2, 10));
        jButtonConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContaActionPerformed(evt);
            }
        });

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
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedValor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxTipoDespesa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDescricao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedEsperado, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jFormattedPagamento))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonTipoDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButtonCancela)
                        .addGap(57, 57, 57)
                        .addComponent(jButtonConsulta)
                        .addGap(57, 57, 57)
                        .addComponent(jButtonSalva)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTipoDespesa))
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonConta))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancela)
                    .addComponent(jButtonConsulta)
                    .addComponent(jButtonSalva))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jButtonTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaActionPerformed
        new CadastroTipoDespesa().setVisible(true);
    }//GEN-LAST:event_jButtonTipoDespesaActionPerformed

    private void jButtonContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContaActionPerformed
        try {
            new CadastroConta().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonContaActionPerformed

    private void jComboBoxTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoDespesaActionPerformed

    private void jComboBoxTipoDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoDespesaMouseClicked
        jComboBoxTipoDespesa.removeAllItems();
        try {
            atualizaTipoDespesa();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxTipoDespesaMouseClicked

    private void jComboBoxContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxContaMouseClicked
        jComboBoxConta.removeAllItems();
        try {
            atualizaConta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxContaMouseClicked

    private void jButtonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvaActionPerformed
        DespesaController despesaController = new DespesaController();
        Double valor = Double.parseDouble(jFormattedValor.getText().replace(",", "."));
        Integer tipoDespesa = jComboBoxTipoDespesa.getSelectedIndex()+1;
        Integer conta = jComboBoxConta.getSelectedIndex()+1;
        String descricao = jTextFieldDescricao.getText();
        String dataPagamento = jFormattedPagamento.getText();
        String dataPagamentoEsperado = jFormattedEsperado.getText();
        try {
            despesaController.cadastraDespesa(valor, tipoDespesa, conta, descricao, dataPagamento, dataPagamentoEsperado);
        } catch (ExceptionDAO | SQLException | ParseException ex) {
            Logger.getLogger(CadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Nova despesa efetuada");
        jFormattedEsperado.setText("");
        jFormattedPagamento.setText("");
        jFormattedValor.setText("");
        jTextFieldDescricao.setText("");
        
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
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroDespesa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancela;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonConta;
    private javax.swing.JButton jButtonSalva;
    private javax.swing.JButton jButtonTipoDespesa;
    private javax.swing.JComboBox<String> jComboBoxConta;
    private javax.swing.JComboBox<String> jComboBoxTipoDespesa;
    private javax.swing.JFormattedTextField jFormattedEsperado;
    private javax.swing.JFormattedTextField jFormattedPagamento;
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
