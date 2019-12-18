/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsuarioTurmaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UsuarioTurma;

/**
 *
 * @author Bruno
 */
public class ListUsuariosTurma extends javax.swing.JFrame {

    /**
     * Creates new form ListUsuariosTurma
     */
    public ListUsuariosTurma() {
        initComponents();
        carregarTabela();
    }
    
    private void carregarTabela(){
        List<UsuarioTurma> listaUsuarioTurmas = UsuarioTurmaDAO.getUsuarioTurmas();
        String[] colunas = {"Id" , "Turma", "Usuario"};
       
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers( colunas );
       
        for (UsuarioTurma usuarioTurma : listaUsuarioTurmas) {
            Object[] linha = { usuarioTurma.getId(), usuarioTurma.getTurma(), usuarioTurma.getUsuario() };
            model.addRow( linha );
        }
        tableUsuariosTurma.setModel( model );
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
        tableUsuariosTurma = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Usuários Turma");
        setResizable(false);

        tableUsuariosTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Turma", "Usuário"
            }
        ));
        jScrollPane1.setViewportView(tableUsuariosTurma);

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
        int linha = tableUsuariosTurma.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar um usuário de uma turma");
        }else{
            int idUsuarioTurma = (int) tableUsuariosTurma.getValueAt(linha, 0);
            //Usuario usuario = (Usuario) tableUsuariosTurma.getValueAt(linha, 2);
            //int usuario = 1;
            FrmUsuarioTurma tela = new FrmUsuarioTurma(idUsuarioTurma);
            tela.setVisible( true );
            tela.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableUsuariosTurma.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar um usuário de uma turma");
        }else{
            int id = (int) tableUsuariosTurma.getValueAt(linha, 0);
            int resposta = JOptionPane.showConfirmDialog(this,
                "Confirma que deseja excluir o usuário da turma " +id+ "?",
                "Excluir usuário da turma",
                JOptionPane.YES_NO_OPTION);
            if( resposta == JOptionPane.YES_OPTION){
                int id2 = (int) tableUsuariosTurma.getValueAt(linha, 0);
                UsuarioTurmaDAO.excluir( id2 );
                carregarTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsuariosTurma;
    // End of variables declaration//GEN-END:variables
}