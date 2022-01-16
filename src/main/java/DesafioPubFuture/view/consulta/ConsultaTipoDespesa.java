/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view.consulta;

import DesafioPubFuture.controller.TipoDespesaController;
import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoDespesa;
import DesafioPubFuture.view.altera.AlteraTipoDespesa;
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
public class ConsultaTipoDespesa extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaTipoDespesa
     */
    public ConsultaTipoDespesa() {
        initComponents();
        atualizaTipoDespesa();
    }

    public void atualizaTipoDespesa(){
        String nome = jTextTipoDespesa.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableTipoDespesa.getModel();
        tableModel.setRowCount(0);
        TipoDespesaController tipoDespesaController = new TipoDespesaController();
        try {
            ArrayList<TipoDespesa> tipos = tipoDespesaController.consultaTipoDespesa(nome);
            tipos.forEach((TipoDespesa tipoDespesa) ->{
                tableModel.addRow(new Object[] {tipoDespesa.getId(),tipoDespesa.getNome()

                });

            });
            jTableTipoDespesa.setModel(tableModel);
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edita(){
        Integer index = jTableTipoDespesa.getSelectedRow();
        TableModel mdl = jTableTipoDespesa.getModel();
        String id = mdl.getValueAt(index, 0).toString();
        String nome = mdl.getValueAt(index, 1).toString();
        AlteraTipoDespesa alteraTipoDespesa = new AlteraTipoDespesa();
        alteraTipoDespesa.setVisible(true);
        alteraTipoDespesa.jLabelnome.setText(id);
        alteraTipoDespesa.jTextNome.setText(nome);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTipoDespesa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextTipoDespesa = new javax.swing.JTextField();
        jButtonCancela = new javax.swing.JButton();
        jButtonEdita = new javax.swing.JButton();
        jButtonApaga = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTipoDespesa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableTipoDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nome"
            }
        ));
        jTableTipoDespesa.setToolTipText("");
        jTableTipoDespesa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableTipoDespesa.getColumnModel().getColumn(0).setMaxWidth(30);
        jTableTipoDespesa.setRowHeight(18);
        jTableTipoDespesa.setShowGrid(true);
        jScrollPane1.setViewportView(jTableTipoDespesa);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Filtrar:");

        jTextTipoDespesa.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextTipoDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextTipoDespesaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jButtonCancela.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButtonCancela.setText("Cancelar");
        jButtonCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaActionPerformed(evt);
            }
        });

        jButtonEdita.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButtonEdita.setText("Editar");
        jButtonEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditaActionPerformed(evt);
            }
        });

        jButtonApaga.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButtonApaga.setText("Apagar");
        jButtonApaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Tipo Despesa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEdita)
                .addGap(74, 74, 74)
                .addComponent(jButtonApaga)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancela)
                    .addComponent(jButtonEdita)
                    .addComponent(jButtonApaga))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jTextTipoDespesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTipoDespesaKeyPressed
        atualizaTipoDespesa();
    }//GEN-LAST:event_jTextTipoDespesaKeyPressed

    private void jButtonEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaActionPerformed
        edita();
    }//GEN-LAST:event_jButtonEditaActionPerformed

    private void jButtonApagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagaActionPerformed
      TipoDespesaController tipoDespesaController = new TipoDespesaController();
      Integer index = jTableTipoDespesa.getSelectedRow();
      TableModel mdl = jTableTipoDespesa.getModel();
      Integer id = Integer.valueOf(mdl.getValueAt(index, 0).toString());
        try {
            tipoDespesaController.deletaTipoDespesa(id);
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoDespesa.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ConsultaTipoDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTipoDespesa().setVisible(true);
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
    private javax.swing.JTable jTableTipoDespesa;
    private javax.swing.JTextField jTextTipoDespesa;
    // End of variables declaration//GEN-END:variables
}
