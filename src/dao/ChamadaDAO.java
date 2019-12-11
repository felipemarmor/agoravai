/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Aula;
import model.Chamada;
import model.Usuario;

/**
 *
 * @author 631420395
 */
public class ChamadaDAO {
    public static void inserir(Chamada chamada){
        String query = "INSERT INTO chamada "
            + " ( codAula, codUsuario, presenca )"
            + " VALUES (  " + chamada.getAula().getId()   + " , "
                     + "  " + chamada.getUsuario().getId() + " ,"
                     + "  " + chamada.isPresenca() + "  ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Chamada chamada){
        String query = "UPDATE chamada SET "
            + " codAula =     " + chamada.getAula().getId()   + " , "
            + " codUsuario =  " + chamada.getUsuario().getId() + " , "
            + " presenca =    " + chamada.isPresenca() + " "
            + " WHERE id =    " + chamada.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idChamada){
        String query = "DELETE FROM chamada "
                    + " WHERE id = " + idChamada;
        Conexao.executar( query );
    }
    
    public static List<Chamada> getChamadas(){
        List<Chamada> lista = new ArrayList<>();
        String query = 
            "SELECT c.id, c.presenca"
                + " a.id, a.nome, "
                + " u.id, u.nome "
                + " FROM nota n "
                + " INNER JOIN aula a "
                + " ON n.codAvaliacao = a.id "
                + " INNER JOIN usuario u "
                + " ON n.codUsuario = u.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Aula aula = new Aula();
                    aula.setId( rs.getInt( 3 ) );
                    aula.setNome( rs.getString( 4 ) );
                    
                    Usuario usu = new Usuario();
                    usu.setId( rs.getInt( 5 ) );
                    usu.setNome( rs.getString( 6 ) );
                    
                    Chamada cha = new Chamada();
                    cha.setId( rs.getInt( 1 ) );
                    cha.setPresenca( rs.getBoolean( 2 ) );
                    cha.setAula( aula );
                    cha.setUsuario( usu );
                    lista.add( cha );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Chamada getChamadaById(int idChamada){
        String query = 
            "SELECT c.id, c.presenca"
                + " a.id, a.nome, "
                + " u.id, u.nome "
                + " FROM nota n "
                + " INNER JOIN aula a "
                + " ON n.codAvaliacao = a.id "
                + " INNER JOIN usuario u "
                + " ON n.codUsuario = u.id "
                + " WHERE id = " + idChamada;
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                rs.next();                    
                Aula aula = new Aula();
                aula.setId( rs.getInt( 3 ) );
                aula.setNome( rs.getString( 4 ) );
                    
                Usuario usu = new Usuario();
                usu.setId( rs.getInt( 5 ) );
                usu.setNome( rs.getString( 6 ) );
                    
                Chamada cha = new Chamada();
                cha.setId( rs.getInt( 1 ) );
                cha.setPresenca( rs.getBoolean( 2 ) );
                cha.setAula( aula );
                cha.setUsuario( usu );
                return cha;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
