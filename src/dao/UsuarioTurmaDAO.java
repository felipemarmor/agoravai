/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.Turma;
import model.UsuarioTurma;

/**
 *
 * @author 631420395
 */
public class UsuarioTurmaDAO {
    public static void inserir(UsuarioTurma usuarioTurma){
        String query = "INSERT INTO usuarioTurma "
            + " ( codTurma, codUsuario )"
            + " VALUES (  " + usuarioTurma.getTurma().getId()   + " , "
                     + "  " + usuarioTurma.getUsuario().getId() + " ) ";
        Conexao.executar( query );
    }
    
    public static void editar(UsuarioTurma usuarioTurma){
        String query = "UPDATE usuarioTurma SET "
            + " codTurma =      " + usuarioTurma.getTurma().getId()   + " , "
            + " codUsuario =    " + usuarioTurma.getUsuario().getId() + "    "
            + " WHERE id = " + usuarioTurma.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idUsuarioTurma){
        String query = "DELETE FROM usuarioTurma "
                    + " WHERE id = " + idUsuarioTurma;
        Conexao.executar( query );
    }
    
    public static List<UsuarioTurma> getUsuarioTurmas(){
        List<UsuarioTurma> lista = new ArrayList<>();
        String query = 
            "SELECT ut.id, "
                + " t.id, t.nome, "
                + " u.id, u.nome "
                + " FROM usuarioTurma ut "
                + " INNER JOIN turma t "
                + " ON ut.codTurma = t.id "
                + " INNER JOIN usuario u "
                + " ON ut.codUsuario = u.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Turma tur = new Turma();
                    tur.setId( rs.getInt( 2 ) );
                    tur.setNome( rs.getString( 3 ) );
                    
                    Usuario usu = new Usuario();
                    usu.setId( rs.getInt( 4 ) );
                    usu.setNome( rs.getString( 5 ) );
                    
                    UsuarioTurma usuTur = new UsuarioTurma();
                    usuTur.setId( rs.getInt( 1 ) );
                    usuTur.setTurma( tur );
                    usuTur.setUsuario( usu );
                    lista.add( usuTur );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static UsuarioTurma getUsuarioTurmaById(int idUsuarioTurma){
        String query = 
            "SELECT ut.id, "
                + " t.id, t.nome, "
                + " u.id, u.nome "
                + " FROM usuarioTurma ut "
                + " INNER JOIN turma t "
                + " ON ut.codTurma = t.id "
                + " INNER JOIN usuario u "
                + " ON ut.codUsuario = u.id "
                + " WHERE id = " + idUsuarioTurma;
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                rs.next();                    
                Turma tur = new Turma();
                tur.setId( rs.getInt( 2 ) );
                tur.setNome( rs.getString( 3 ) );
                    
                Usuario usu = new Usuario();
                usu.setId( rs.getInt( 4 ) );
                usu.setNome( rs.getString( 5 ) );
                    
                UsuarioTurma usuTur = new UsuarioTurma();
                usuTur.setId( rs.getInt( 1 ) );
                usuTur.setTurma( tur );
                usuTur.setUsuario( usu );
                return usuTur;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }

    public static boolean verificar(UsuarioTurma usutur) {
        String query = "SELECT codTurma, codUsuario FROM usuarioTurma WHERE codTurma = " + usutur.getTurma().getId() +
                                                " and codUsuario = " + usutur.getUsuario().getId() + "";
        ResultSet rs = Conexao.consultar( query );
        if(rs != null){
            try{
                while (rs.next()){ 
                    return true;
                }
            }catch(Exception e){
             return false;   
            }
        }else{
            return false;
        }
        return false;
    }
}
