/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Disciplina;

/**
 *
 * @author 631420395
 */
public class DisciplinaDAO {
    public static void inserir(Disciplina disciplina){
        String query = "INSERT INTO disciplina ( nome ) "
                + " VALUES ('" + disciplina.getNome() + "'); ";
        Conexao.executar( query );
    }
    
    public static void editar(Disciplina disciplina){
        String query = "UPDATE disciplina SET "
                     + " nome =  '" + disciplina.getNome() + "' "
                     + " WHERE id = " + disciplina.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idDisciplina){
        String query = "DELETE FROM disciplina "
                     + " WHERE id = " + idDisciplina;
        Conexao.executar( query );
    }
    
    public static List<Disciplina> getDisciplinas(){
        List<Disciplina> lista = new ArrayList<>();
        String query = "SELECT id, nome FROM disciplina ORDER BY nome";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Disciplina dis = new Disciplina();
                    dis.setId( rs.getInt( 1 ) );
                    dis.setNome( rs.getString( 2 ) );
                    lista.add(dis);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Disciplina getDisciplinaById( int idDisciplina ){
 
        String query = "SELECT id, nome FROM disciplina "
                     + " WHERE id = " + idDisciplina;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Disciplina dis = new Disciplina();
                dis.setId( rs.getInt( 1 ) );
                dis.setNome( rs.getString( 2 ) );
                return dis;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
