/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view.consulta;

import DesafioPubFuture.controller.TipoReceitaController;
import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.TipoReceita;
import DesafioPubFuture.view.altera.AlteraTipoReceita;
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
public class ConsultaTipoReceita extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaTipoReceita
     */
    public ConsultaTipoReceita() throws SQLException,ExceptionDAO{
        initComponents();
        atualizaTipoReceita();
        
    }

    public void atualizaTipoReceita()throws SQLException, ExceptionDAO{
        String nome = jTextConsulta.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableTipoReceita.getModel();
        tableModel.setRowCount(0);
        TipoReceitaController tipoReceitaController = new TipoReceitaController();
        try {
            ArrayList<TipoReceita> tipos = tipoReceitaController.consultaTipoReceita(nome);
            tipos.forEach((TipoReceita tipoReceita) ->{
                tableModel.addRow(new Object[] {tipoReceita.getId(),tipoReceita.getNome()

                });

            });
            jTableTipoReceita.setModel(tableModel);
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edita(){
        Integer index = jTableTipoReceita.getSelectedRow();
        TableModel mdl = jTableTipoReceita.getModel();
        String id = mdl.getValueAt(index, 0).toString();
        String nome = mdl.getValueAt(index, 1).toString();
        AlteraTipoReceita alteraTipoReceita = new AlteraTipoReceita();
        alteraTipoReceita.setVisible(true);
        alteraTipoReceita.jLabelId.setText(id);
        alteraTipoReceita.jTextFieldNome.setText(nome);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTipoReceita = new javax.swing.JTable();
        jTextConsulta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonEdita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTipoReceita.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableTipoReceita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipoReceita.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableTipoReceita.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableTipoReceita.getColumnModel().getColumn(0).setMaxWidth(30);
        jTableTipoReceita.setRowHeight(18);
        jTableTipoReceita.setShowGrid(true);
        jTableTipoReceita.setUpdateSelectionOnSort(false);
        jTableTipoReceita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoReceitaMouseClicked(evt);
            }
        });
        jTableTipoReceita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableTipoReceitaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTipoReceita);

        jTextConsulta.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextConsultaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Filtrar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo de Receitas");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButton2.setText("Apagar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonEdita.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButtonEdita.setText("Editar");
        jButtonEdita.setToolTipText("");
        jButtonEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(69, 69, 69)
                .addComponent(jButtonEdita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButtonEdita))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextConsultaKeyTyped
        try {
            atualizaTipoReceita();
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextConsultaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TipoReceitaController tipoReceitaController = new TipoReceitaController();
        Integer index  = jTableTipoReceita.getSelectedRow();
        TableModel mdl = jTableTipoReceita.getModel();
        Integer id = Integer.valueOf(mdl.getValueAt(index, 0).toString());
        try {
            tipoReceitaController.deletaTipoReceita(id);
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaTipoReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableTipoReceitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTipoReceitaKeyPressed

    }//GEN-LAST:event_jTableTipoReceitaKeyPressed

    private void jTableTipoReceitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoReceitaMouseClicked
       
    }//GEN-LAST:event_jTableTipoReceitaMouseClicked

    private void jButtonEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaActionPerformed
        edita();

    }//GEN-LAST:event_jButtonEditaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaTipoReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultaTipoReceita().setVisible(true);
                } catch (SQLException | ExceptionDAO ex) {
                    Logger.getLogger(ConsultaTipoReceita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEdita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTipoReceita;
    private javax.swing.JTextField jTextConsulta;
    // End of variables declaration//GEN-END:variables
}
