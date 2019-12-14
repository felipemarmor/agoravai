/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Criptografia;
import model.Usuario;

/**
 *
 * @author Bruno
 */
public class FrmUsuario extends javax.swing.JFrame {
    
    private Usuario usuario;
    
    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        initComponents();
    }
    
    public FrmUsuario(int idUsuario) {
        initComponents();
        carregarFormulario(idUsuario);
    }
    
    private void carregarFormulario(int idUsuario){
        usuario = UsuarioDAO.getUsuarioById( idUsuario );
        txtNome.setText(usuario.getNome());
        if(usuario.getTipo() == 0){
            rbAdmin.isSelected();
        }
        if(usuario.getTipo() == 1){
            rbAluno.isSelected();
        }
        if(usuario.getTipo() == 2){
            rbProf.isSelected();
        }
        txtLogin.setText(usuario.getLogin());
        pwdSenha.setText(usuario.getSenha());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        rbAluno = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();
        rbProf = new javax.swing.JRadioButton();
        pwdSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Usuário");

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(rbAluno);
        rbAluno.setText("Aluno");

        buttonGroupTipo.add(rbAdmin);
        rbAdmin.setSelected(true);
        rbAdmin.setText("Administrador");

        buttonGroupTipo.add(rbProf);
        rbProf.setText("Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(pwdSenha))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbAdmin)
                                .addGap(18, 18, 18)
                                .addComponent(rbAluno)
                                .addGap(18, 18, 18)
                                .addComponent(rbProf))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAluno)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(rbAdmin)
                        .addComponent(rbProf, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar() {
        txtNome.setText("");
        txtLogin.setText("");
        pwdSenha.setText("");
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String erro = "";
        if(nome.isEmpty()){
            erro += "Nome\n";
        }
        String login = txtLogin.getText();
        if(login.isEmpty()){
            erro += "Login\n";
        }
        String senha = pwdSenha.getText();
        if(senha.isEmpty()){
            erro += "Senha\n";
        }
        if(! erro.isEmpty()){
            JOptionPane.showMessageDialog(this, 
                "Você esqueceu de preencher os seguintes campos:\n" 
                + erro );
        }else{
            if( usuario == null ){
                if(rbAdmin.isSelected()){
                    Usuario admin = new Usuario();
                    admin.setNome(nome);
                    admin.setTipo(Usuario.ADMINISTRADOR);
                    admin.setLogin(login);
                    admin.setSenha(Criptografia.criptografar(senha));
                    //admin.setSenha(senha);
                    UsuarioDAO.inserir(admin);
                }
                if(rbAluno.isSelected()){
                    Usuario aluno = new Usuario();
                    aluno.setNome(nome);
                    aluno.setTipo(Usuario.ALUNO);
                    aluno.setLogin(login);
                    aluno.setSenha(Criptografia.criptografar(senha));
                    //admin.setSenha(senha);
                    UsuarioDAO.inserir(aluno);
                }
                if(rbProf.isSelected()){
                    Usuario prof = new Usuario();
                    prof.setNome(nome);
                    prof.setTipo(Usuario.PROFESSOR);
                    prof.setLogin(login);
                    prof.setSenha(Criptografia.criptografar(senha));
                    //admin.setSenha(senha);
                    UsuarioDAO.inserir(prof);
                }
            }else{
                if(rbAdmin.isSelected()){                    
                    usuario.setNome(nome);
                    usuario.setTipo(Usuario.ADMINISTRADOR);
                    usuario.setLogin(login);
                    usuario.setSenha(Criptografia.criptografar(senha));
                    UsuarioDAO.editar(usuario);
                }
                if(rbAluno.isSelected()){                    
                    usuario.setNome(nome);
                    usuario.setTipo(Usuario.ALUNO);
                    usuario.setLogin(login);
                    usuario.setSenha(Criptografia.criptografar(senha));
                    UsuarioDAO.editar(usuario);
                }
                if(rbProf.isSelected()){
                    usuario.setNome(nome);
                    usuario.setTipo(Usuario.PROFESSOR);
                    usuario.setLogin(login);
                    usuario.setSenha(Criptografia.criptografar(senha));
                    UsuarioDAO.editar(usuario);
                }
                this.dispose();
            }
        }
        limpar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pwdSenha;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbAluno;
    private javax.swing.JRadioButton rbProf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
