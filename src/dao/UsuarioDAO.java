package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author assparremberger
 */
public class UsuarioDAO {
    
    public static void inserir(Usuario usuario){
        String query = "INSERT INTO usuario ( nome, tipo, login, senha ) "
                + " VALUES ('" + usuario.getNome() + "' , "
                        + "  " + usuario.getTipo() + " , "
                        + "  '" + usuario.getLogin() + "' , "
                        + "  '" + usuario.getSenha() + "' ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Usuario usuario){
        String query = "UPDATE usuario SET "
                     + " nome =  '" + usuario.getNome() + "' , "
                     + " tipo =   " + usuario.getTipo() + " , "
                     + " login = '" + usuario.getLogin() + "' , "
                     + " senha = '" + usuario.getSenha()+ "' "
                     + " WHERE id = " + usuario.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idUsuario){
        String query = "DELETE FROM usuario  "
                     + " WHERE id = " + idUsuario;
        Conexao.executar( query );
    }
    
    public static List<Usuario> getUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        String query = "SELECT id, nome, tipo, login, senha FROM usuario ORDER BY tipo";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    Usuario usu = new Usuario();
                    usu.setId( rs.getInt( 1 ) );
                    usu.setNome( rs.getString( 2 ) );
                    usu.setTipo( rs.getInt( 3 ) );
                    usu.setLogin( rs.getString( 4 ) );
                    usu.setSenha( rs.getString( 5 ) );
                    lista.add(usu);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Usuario getUsuarioById( int idUsuario ){
 
        String query = "SELECT id, nome, tipo, login, senha FROM usuario "
                     + " WHERE id = " + idUsuario;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Usuario usu = new Usuario();
                usu.setId( rs.getInt( 1 ) );
                usu.setNome( rs.getString( 2 ) );
                usu.setTipo( rs.getInt( 3 ) );
                usu.setLogin( rs.getString( 4 ) );
                usu.setSenha( rs.getString( 5 ) );
                return usu;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
    
    public static int logar(String login, String senha){
        String query = "SELECT tipo FROM usuario WHERE login = '" + login + "' and senha = '" + senha + "'";
        ResultSet rs = Conexao.consultar( query );

        if( rs != null ){
            try {
                rs.next();  
                int tipo = rs.getInt( 1 );         
                return tipo;
            } catch (Exception e) {
                return 3;
            }
        }else{
            return 4;
        }
    }
}
