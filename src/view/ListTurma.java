/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.TurmaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turma;

/**
 *
 * @author Bruno
 */
public class ListTurma extends javax.swing.JFrame {

    /**
     * Creates new form ListTurma
     */
    public ListTurma() {
        initComponents();
        carregarTabela();
    }
    
     private void carregarTabela(){
        List<Turma> listaTurmas = TurmaDAO.getTurmas();
        String[] colunas = {"Id" , "Nome", "Disciplina"};
       
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers( colunas );
       
        for (Turma turma : listaTurmas) {
            Object[] linha = { turma.getId(), turma.getNome(), turma.getDisciplina() };
            model.addRow( linha );
        }
        tableTurmas.setModel( model );
        
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
        tableTurmas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista Turmas");
        setResizable(false);

        tableTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Disciplina"
            }
        ));
        jScrollPane1.setViewportView(tableTurmas);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tableTurmas.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar uma turma");
        }else{
            int idTurma = (int) tableTurmas.getValueAt(linha, 0);
            FrmTurma tela = new FrmTurma(idTurma);
            tela.setVisible( true );
            tela.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableTurmas.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar uma turma");
        }else{
            String nome = (String) tableTurmas.getValueAt(linha, 1);
            int resposta = JOptionPane.showConfirmDialog(this,
                "Confirma que deseja excluir a turma " +nome+ "?",
                "Excluir Turma",
                JOptionPane.YES_NO_OPTION);
            if( resposta == JOptionPane.YES_OPTION){
                int id = (int) tableTurmas.getValueAt(linha, 0);
                TurmaDAO.excluir( id );
                carregarTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTurmas;
    // End of variables declaration//GEN-END:variables

}
