/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesafioPubFuture.view.consulta;

import DesafioPubFuture.controller.ReceitaController;
import DesafioPubFuture.dao.ExceptionDAO;
import DesafioPubFuture.model.Receita;
import DesafioPubFuture.view.altera.AlteraReceita;
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
public class ConsultaReceita extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaReceita
     * @throws java.sql.SQLException
     * @throws DesafioPubFuture.dao.ExceptionDAO
     */
    public ConsultaReceita()throws SQLException,ExceptionDAO{
        initComponents();
        atualizaReceita();
    }

    public void atualizaReceita()throws SQLException, ExceptionDAO{
        String descricao  = jTextFieldDescricao.getText();
        DefaultTableModel tablemodel = (DefaultTableModel) jTable1.getModel();
        tablemodel.setRowCount(0);
        ReceitaController receitaController = new ReceitaController();
        ArrayList<Receita> receitas = receitaController.consultaReceita(descricao);
        receitas.forEach((Receita receita) -> {
            tablemodel.addRow(new Object[]{receita.getId(), receita.getValor(),
                receita.getTipoReceita().getNome(), receita.getConta().getNome(),
                receita.getDescricao(), receita.getDataRecebimento(),
                receita.getDataRecebimentoEsperado()
            });
        });
        
        jTable1.setModel(tablemodel); 
    }
    
    public void edita()throws ExceptionDAO,SQLException{
        if(jTable1.getSelectedRow()>=0){
            Integer index = jTable1.getSelectedRow();
            TableModel mdl = jTable1.getModel();
            String id = mdl.getValueAt(index, 0).toString();
            String valor = mdl.getValueAt(index, 1).toString();
            String descricao = mdl.getValueAt(index, 4).toString();
            AlteraReceita alteraReceita = new AlteraReceita();
            alteraReceita.setVisible(true);
            alteraReceita.jLabelId.setText(id);
            alteraReceita.jFormattedValor.setText(valor.replace(".", ","));
            alteraReceita.jTextFieldDescricao.setText(descricao);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jButtonCancela = new javax.swing.JButton();
        jButtonEdita = new javax.swing.JButton();
        jButtonApaga = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Valor", "Tipo", "Conta", "Descrição", "Recebimento", "Rcbto Esperado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(18);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Filtrar por Descrição:");

        jTextFieldDescricao.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consultar Receita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButtonCancela)
                        .addGap(122, 122, 122)
                        .addComponent(jButtonEdita)
                        .addGap(144, 144, 144)
                        .addComponent(jButtonApaga)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancela)
                    .addComponent(jButtonEdita)
                    .addComponent(jButtonApaga))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelaActionPerformed

    private void jButtonEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaActionPerformed
        try {
            edita();
        } catch (ExceptionDAO | SQLException ex) {
            Logger.getLogger(ConsultaReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditaActionPerformed

    private void jButtonApagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagaActionPerformed
        if(jTable1.getSelectedRow()>0){
            ReceitaController receitaController = new ReceitaController();
            Integer index = jTable1.getSelectedRow();
            TableModel mdl = jTable1.getModel();
            Integer id = Integer.valueOf(mdl.getValueAt(index, 0).toString());
            try {
                receitaController.deletaReceita(id);
            } catch (SQLException | ExceptionDAO ex) {
                Logger.getLogger(ConsultaReceita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonApagaActionPerformed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
        try {
            atualizaReceita();
        } catch (SQLException | ExceptionDAO ex) {
            Logger.getLogger(ConsultaReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed

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
            java.util.logging.Logger.getLogger(ConsultaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultaReceita().setVisible(true);
                } catch (SQLException | ExceptionDAO ex) {
                    Logger.getLogger(ConsultaReceita.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables
}
