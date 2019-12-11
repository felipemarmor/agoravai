/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Avaliacao;
import model.Usuario;
import model.Nota;

/**
 *
 * @author 631420395
 */
public class NotaDAO {
    public static void inserir(Nota nota){
        String query = "INSERT INTO nota "
            + " ( codAvaliacao, codUsuario, conceito )"
            + " VALUES (  " + nota.getAvaliacao().getId()   + " , "
                     + "  " + nota.getUsuario().getId() + " , "
                     + " '" + nota.getConceito() + "'  ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Nota nota){
        String query = "UPDATE nota SET "
            + " codAvaliacao =  " + nota.getAvaliacao().getId()   + " , "
            + " codUsuario =    " + nota.getUsuario().getId() + " , "
            + " conceito =     '" + nota.getConceito() + "' "
            + " WHERE id =      " + nota.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idNota){
        String query = "DELETE FROM nota "
                    + " WHERE id = " + idNota;
        Conexao.executar( query );
    }
    
    public static List<Nota> getNotas(){
        List<Nota> lista = new ArrayList<>();
        String query = 
            "SELECT n.id, n.conceito"
                + " a.id, a.nome, "
                + " u.id, u.nome "
                + " FROM nota n "
                + " INNER JOIN avaliacao a "
                + " ON n.codAvaliacao = a.id "
                + " INNER JOIN usuario u "
                + " ON n.codUsuario = u.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Avaliacao ava = new Avaliacao();
                    ava.setId( rs.getInt( 3 ) );
                    ava.setNome( rs.getString( 4 ) );
                    
                    Usuario usu = new Usuario();
                    usu.setId( rs.getInt( 5 ) );
                    usu.setNome( rs.getString( 6 ) );
                    
                    Nota nota = new Nota();
                    nota.setId( rs.getInt( 1 ) );
                    nota.setConceito( rs.getString(2) );
                    nota.setAvaliacao( ava );
                    nota.setUsuario( usu );
                    lista.add( nota );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Nota getNotaById(int idNota){
        String query = 
            "SELECT n.id, n.conceito"
                + " a.id, a.nome, "
                + " u.id, u.nome "
                + " FROM nota n "
                + " INNER JOIN avaliacao a "
                + " ON n.codAvaliacao = a.id "
                + " INNER JOIN usuario u "
                + " ON n.codUsuario = u.id "
                + " WHERE id = " + idNota;
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                rs.next();                    
                Avaliacao ava = new Avaliacao();
                ava.setId( rs.getInt( 3 ) );
                ava.setNome( rs.getString( 4 ) );
                    
                Usuario usu = new Usuario();
                usu.setId( rs.getInt( 5 ) );
                usu.setNome( rs.getString( 6 ) );
                    
                Nota nota = new Nota();
                nota.setId( rs.getInt( 1 ) );
                nota.setConceito( rs.getString(2));
                nota.setAvaliacao( ava );
                nota.setUsuario( usu );
                return nota;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
