/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view.consulta;

import DesafioPubFuture.controller.TipoContaController;
import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoConta;
import DesafioPubFuture.view.altera.AlteraTipoConta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class ConsultaTipoConta extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaTipoConta
     */
    public ConsultaTipoConta() throws SQLException {
        initComponents();
        try {
            atualizaTipoConta();
        } catch (ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaTipoConta() throws SQLException, ExceptionDAO{
        String nome = jTextFieldNome.getText();
        DefaultTableModel tablemodel = (DefaultTableModel) jTableTipoConta.getModel();
        tablemodel.setRowCount(0);
        TipoContaController tipoContaController = new TipoContaController();
        ArrayList<TipoConta> tipocontas = tipoContaController.consultaTipoConta(nome);
        tipocontas.forEach((TipoConta tipoConta) -> {
        tablemodel.addRow(new Object[] {tipoConta.getId(), tipoConta.getNome(),tipoConta.getInstFinanceira().getNome()});
        
        });
        jTableTipoConta.setModel(tablemodel);
                
    }
    
    public void edita(){
        if(jTableTipoConta.getSelectedRow()> 0){
            Integer index = jTableTipoConta.getSelectedRow();
            TableModel mdl = jTableTipoConta.getModel();
            String id = mdl.getValueAt(index, 0).toString();
            String nome = mdl.getValueAt(index, 1).toString();
            String inst = mdl.getValueAt(index, 2).toString();
            AlteraTipoConta alteraTipoConta = new AlteraTipoConta();
            alteraTipoConta.setVisible(true);
            alteraTipoConta.jLabelId.setText(id);
            alteraTipoConta.jTextNome.setText(nome);}
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTipoConta = new javax.swing.JTable();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonCancela = new javax.swing.JButton();
        jButtonEdita = new javax.swing.JButton();
        jButtonApaga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar tipo de Conta");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTipoConta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableTipoConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Inst. Financeira"
            }
        ));
        jTableTipoConta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableTipoConta.setShowGrid(true);
        jScrollPane1.setViewportView(jTableTipoConta);

        jTextFieldNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonCancela.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonCancela.setText("Cancelar");
        jButtonCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaActionPerformed(evt);
            }
        });

        jButtonEdita.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonEdita.setText("Editar");
        jButtonEdita.setToolTipText("");
        jButtonEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditaActionPerformed(evt);
            }
        });

        jButtonApaga.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonApaga.setText("Apagar");
        jButtonApaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButtonCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEdita)
                .addGap(59, 59, 59)
                .addComponent(jButtonApaga)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancela)
                    .addComponent(jButtonEdita)
                    .addComponent(jButtonApaga))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        try {
            atualizaTipoConta();
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jButtonEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaActionPerformed
        edita();
    }//GEN-LAST:event_jButtonEditaActionPerformed

    private void jButtonApagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagaActionPerformed
        TipoContaController tipoContaController = new TipoContaController();
        Integer index = jTableTipoConta.getSelectedRow();
        TableModel mdl = jTableTipoConta.getModel();
        Integer id = Integer.valueOf(mdl.getValueAt(index, 0).toString());
        try {
            tipoContaController.deletaTipoConta(id);
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonApagaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultaTipoConta().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaTipoConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApaga;
    private javax.swing.JButton jButtonCancela;
    private javax.swing.JButton jButtonEdita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTipoConta;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
